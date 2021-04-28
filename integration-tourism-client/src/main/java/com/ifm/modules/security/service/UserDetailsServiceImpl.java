package com.ifm.modules.security.service;

import com.ifm.comment.config.LoginProperties;
import com.ifm.comment.exception.EntityNotFoundException;
import com.ifm.modules.client.entity.UserInfo;
import com.ifm.modules.client.service.IUserInfoService;
import com.ifm.modules.security.service.dto.JwtUserDto;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserInfoService userInfoService;

    @Autowired
    LoginProperties loginProperties;

    /**
     * map用户信息缓存
     */
    static Map<String, JwtUserDto> userDtoCache = new ConcurrentHashMap<>();


    @Override
    public JwtUserDto loadUserByUsername(String username) {
        boolean searchDb = true;
        JwtUserDto jwtUserDto = null;

//         判断是否开启 缓存  并且判断map里面是否包含username
        if (loginProperties.isCacheEnable() && userDtoCache.containsKey(username)) {
            jwtUserDto = userDtoCache.get(username);
            searchDb = false;
        }
        if (searchDb) {
            UserInfo userInfo;
            try {
                //根据用户名查询用户信息
                userInfo = userInfoService.findByName(username);
            } catch (EntityNotFoundException e) {
                // SpringSecurity会自动转换UsernameNotFoundException为BadCredentialsException
                throw new UsernameNotFoundException("", e);
            }
            if (userInfo == null) {
                throw new UsernameNotFoundException("用户名或密码错误");
            } else {
//                if (!user.getEnabled()) {
//                    throw new BadRequestException("账号未激活！");
//                }

                //装权限
                List<GrantedAuthority> authorities = Lists.newArrayList();
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("不知道");
                authorities.add(grantedAuthority);

                jwtUserDto = new JwtUserDto(userInfo, authorities);
                //把用户信息保存在缓存里面
                userDtoCache.put(username, jwtUserDto);
            }
        }
        return jwtUserDto;
    }
}
