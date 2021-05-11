
package com.ifm.modules.system.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.extra.mail.MailUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.utils.RedisUtils;
import com.ifm.modules.security.security.TokenProvider;
import com.ifm.modules.security.service.OnlineUserService;
import com.ifm.modules.security.service.dto.AuthUserDto;
import com.ifm.modules.security.service.dto.JwtUserDto;
import com.ifm.modules.system.entity.SysUser;
import com.ifm.modules.system.mapper.SysUserMapper;
import com.ifm.modules.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
*
*@ClassName:系统用户 服务实现类
*@Description:
*@author: zhou
*@date 2021-04-27
*
*/
@Service
@Slf4j
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    TokenProvider tokenProvider;

    @Autowired
    OnlineUserService onlineUserService;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public List<SysUser> listAll() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        List<SysUser> sysUsers = baseMapper.selectList(queryWrapper);
        return sysUsers;

    }

    @Override
    public SysUser findByName(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",username);
       return baseMapper.selectOne(queryWrapper);
    }



    @Override
    public String login(AuthUserDto authUser, HttpServletRequest request) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authUser.getUsername(), authUser.getPassword());

        //验证用户名和密码是否正确
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        //更新Security对象 用户信息对象
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);

        final JwtUserDto jwtUserDto = (JwtUserDto) authentication.getPrincipal();

        // 保存在线信息
        onlineUserService.save(jwtUserDto, token, request);

        redisUtils.set(token, authUser.getUsername(), 86400);
        return "登录成功token=>" + token;

    }

    @Override
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) {
        //运用hutool工具包更简单 不需要配置类
        //HuTool定义图形验证码的长和宽,验证码的位数，干扰线的条数
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        log.info(lineCaptcha.getCode());
        //将验证码放入session
        request.getSession().setAttribute("code", lineCaptcha.getCode());
        try {
            //写入浏览器
            ServletOutputStream outputStream = response.getOutputStream();
            lineCaptcha.write(outputStream);
            response.setContentType("image/jpeg");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String sendMail() {
        String content = "<a href='http://localhost:8888/system/user/login'>你好，欢迎注册网站，请点击链接激活</a>";
        String send = MailUtil.send("2030900727@qq.com", "账户激活", content, false);
        return send;
    }


}
