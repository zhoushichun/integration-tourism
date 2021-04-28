
package com.ifm.modules.client.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.utils.RedisUtils;
import com.ifm.modules.client.entity.UserInfo;
import com.ifm.modules.client.mapper.UserInfoMapper;
import com.ifm.modules.client.service.IUserInfoService;
import com.ifm.modules.security.security.TokenProvider;
import com.ifm.modules.security.service.OnlineUserService;
import com.ifm.modules.security.service.dto.AuthUserDto;
import com.ifm.modules.security.service.dto.JwtUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
*
*@ClassName:用户 服务实现类
*@Description:
*@author: zhou
*@date 2021-04-27
*
*/
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

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

    @Override
    public List<UserInfo> listAll() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        return  baseMapper.selectList(queryWrapper);
    }

    @Override
    public UserInfo findByName(String username) {
        QueryWrapper<UserInfo> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone",username);
        return baseMapper.selectOne(userQueryWrapper);
    }

    @Override
    public String login(AuthUserDto authUser, HttpServletRequest request) {
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
        //更新Security对象 用户信息对象
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(authentication);
        String token = tokenProvider.createToken(authentication);
        final JwtUserDto jwtUserDto = (JwtUserDto) authentication.getPrincipal();
        // 保存在线信息
        onlineUserService.save(jwtUserDto, token, request);
        redisUtils.set(token, authUser.getUsername(), 86400);
        return "登录成功token=>" + token;
    }


}
