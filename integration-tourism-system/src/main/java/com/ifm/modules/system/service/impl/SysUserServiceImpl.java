
package com.ifm.modules.system.service.impl;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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


}
