package com.ifm.modules.security.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ifm.modules.client.entity.UserInfo;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Getter
public class JwtUserDto implements UserDetails {

    private UserInfo user;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDto(UserInfo userInfo, Collection<? extends GrantedAuthority> authorities) {
        this.user = userInfo;
        this.authorities = authorities;
    }
    @Override
    public String getUsername() {
        return user.getPhone();
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return  user.getStatus().toString().equals("0") ? true :false;
    }
}
