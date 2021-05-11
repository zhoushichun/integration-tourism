
package com.ifm.modules.client.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.Message;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.config.SecurityProperties;
import com.ifm.comment.result.Result;
import com.ifm.comment.utils.Checkcellphone;
import com.ifm.comment.utils.RedisUtils;
import com.ifm.comment.utils.SecurityUtils;
import com.ifm.comment.utils.WeChatUtil;
import com.ifm.modules.client.entity.DTO.UserInfoVo;
import com.ifm.modules.client.entity.UserInfo;
import com.ifm.modules.client.mapper.UserInfoMapper;
import com.ifm.modules.client.service.ITouristInfoService;
import com.ifm.modules.client.service.IUserInfoService;
import com.ifm.modules.security.security.TokenProvider;
import com.ifm.modules.security.service.OnlineUserService;
import com.ifm.modules.security.service.dto.AuthUserDto;
import com.ifm.modules.security.service.dto.JwtUserDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName:用户 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-27
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Value("${wxMini.appId}")
    public String appId;
    @Value("${wxMini.secret}")
    public String secret;

    @Autowired
    SecurityUtils securityUtils;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;


    @Autowired
    TokenProvider tokenProvider;

    @Autowired

    OnlineUserService onlineUserService;


    @Autowired
    RedisUtils redisUtils;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ITouristInfoService touristInfoService;
    @Autowired
    SecurityProperties securityProperties;

    @Override
    public List<UserInfo> listAll() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public UserInfo findByName(String username) {
        QueryWrapper<UserInfo> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", username);
        return baseMapper.selectOne(userQueryWrapper);
    }

    @Override
    public Result login(AuthUserDto authUser, HttpServletRequest request) {
        //    Object getCredentials(); //获取凭证 也就是密码
        //
        //    Object getDetails(); 获取详情
        //
        //    Object getPrincipal(); 获取JwtUserDto对象
        //
        //    boolean isAuthenticated(); 是否被认证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authUser.getUsername(), authUser.getPassword());
        System.out.println(authenticationToken);
        //验证用户名和密码是否正确
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//        更新Security对象 用户信息对象
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(authentication);

        String token = tokenProvider.createToken(authentication);
        final JwtUserDto jwtUserDto = (JwtUserDto) authentication.getPrincipal();
        // 保存在线信息
        onlineUserService.save(jwtUserDto, token, request);

        Map<String, Object> authInfo = new HashMap<String, Object>(2) {{
            put("token", securityProperties.getTokenStartWith() + token);
            put("user", jwtUserDto);
        }};
        return Result.SUCCESS(authInfo);
    }

    @Override
    public String messagesLogin(String phone) {
        boolean validPhoneNumber = Checkcellphone.isValidPhoneNumber(phone);
        if (!validPhoneNumber) {
            return "请输入正确的手机号码";
        }

        String authcode = "1" + RandomStringUtils.randomNumeric(5);//生成随机数,我发现生成5位随机数时，如果开头为0，发送的短信只有4位，这里开头加个1，保证短信的正确性
        redisUtils.set(phone, authcode);//将验证码存入缓存
        Message.messagePost(phone, authcode);//发送短息
        return "发送成功";

    }

    @Override
    public String verificationCode(String u_phone, String code) {

        //验证成功 查看是否有注册账号
        //注册  和不注册
        //返回用户id
        if (redisUtils.get(u_phone).equals(code)) {
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone", u_phone).eq("status", 0).eq("deleted", 0);
            UserInfo userInfo = baseMapper.selectOne(queryWrapper);
            //能查询到数据
            if (userInfo != null) {
                //能查询到数据
                //返回用户的id
                return userInfo.getId().toString();
            } else {
                //不能查询到数据
                //注册用户
                UserInfo userInfo1 = new UserInfo();
                userInfo1.setPhone(u_phone);
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String encode = bCryptPasswordEncoder.encode("123456");
                userInfo1.setPassword(encode);
                userInfo1.insert();
                return userInfo1.getId().toString();

            }

        } else {
            return "登录失败";
        }
    }

    @Override
    public UserInfo QueryUser(Long accountId) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", accountId).eq("status", 0).eq("deleted", 0);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Result WeChatLogin(String code, HttpServletRequest request) {
        System.out.println("code===" + code);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        String str = WeChatUtil.httpRequest(url, "GET", null);
        JSONObject jsonObject = JSONObject.parseObject(str);
        String openid = jsonObject.get("openid").toString();
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openid).eq("status", 0).eq("deleted", 0);
        UserInfo user = baseMapper.selectOne(queryWrapper);
        if (user == null) {
            UserInfo userInfo = new UserInfo();
            userInfo.setOpenId(openid);
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encode = bCryptPasswordEncoder.encode("123456");
            userInfo.setPassword(encode);
            String s = UUID.randomUUID().toString();
            userInfo.setAccount(s);
            //添加到
            userInfo.insert();
            AuthUserDto authUserDto = new AuthUserDto();
            authUserDto.setUsername(s);
            authUserDto.setPassword("123456");
            return Result.SUCCESS(login(authUserDto, request));
        } else {
            AuthUserDto authUserDto = new AuthUserDto();
            authUserDto.setUsername(user.getAccount());
            authUserDto.setPassword("123456");
            return Result.SUCCESS(login(authUserDto, request));
        }
    }

    @Override
    public String addWeChat(UserInfoVo userInfoVo) {
        System.out.println("111");
        System.out.println("111");
        System.out.println("111");
        System.out.println("111");

        SecurityUtils.getCurrentUsername();
        Long currentUserId = securityUtils.getCurrentUserId();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(currentUserId);
        userInfo.setNickName(userInfoVo.getNickName());
        userInfo.setAvatarName(userInfoVo.getAvatarName());
        userInfo.setGender(userInfoVo.getGender());
        boolean b = userInfo.updateById();
        if (!b) {
            return "添加失败";
        }
        return "添加场馆";
    }

}


