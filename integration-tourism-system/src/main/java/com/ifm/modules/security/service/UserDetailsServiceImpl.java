package com.ifm.modules.security.service;

import com.ifm.comment.config.LoginProperties;
import com.ifm.comment.exception.EntityNotFoundException;
import com.ifm.modules.security.service.dto.JwtUserDto;
import com.ifm.modules.system.entity.SysUser;
import com.ifm.modules.system.service.ISysUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    public ISysUserService sysUserService;

    @Autowired
    public LoginProperties loginProperties;

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
            SysUser sysUser;
            try {
                //根据用户名查询用户信息
                sysUser = sysUserService.findByName(username);
            } catch (EntityNotFoundException e) {
                // SpringSecurity会自动转换UsernameNotFoundException为BadCredentialsException
                throw new UsernameNotFoundException("", e);
            }
            if (sysUser == null) {
                throw new UsernameNotFoundException("用户名或者密码错误");
            } else {
//                if (!user.getEnabled()) {
//                    throw new BadRequestException("账号未激活！");
//                }

                //装权限
                List<GrantedAuthority> authorities = Lists.newArrayList();
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("buzhidao");
                authorities.add(grantedAuthority);
                //1.用户名 2.角色id 3.权限
//                String encode = new BCryptPasswordEncoder().encode(user.getPassword());
//                System.out.println(encode);
                ArrayList<Long> longs = new ArrayList<>();
                longs.add(1l);
                longs.add(2l);
                longs.add(3l);
                longs.add(4l);
                jwtUserDto = new JwtUserDto(sysUser, longs, authorities);
                //把用户信息保存在缓存里面
                userDtoCache.put(username, jwtUserDto);
            }
        }
        return jwtUserDto;
    }
}
