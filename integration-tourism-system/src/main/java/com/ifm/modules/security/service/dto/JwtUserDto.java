package com.ifm.modules.security.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ifm.modules.system.entity.SysUser;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Getter
public class JwtUserDto implements UserDetails {

    private SysUser sysUser;
    private List<Long> role;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDto(SysUser sysUser, List<Long> role, Collection<? extends GrantedAuthority> authorities) {
        this.sysUser = sysUser;
        this.role = role;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return sysUser.getAccount();
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return sysUser.getPassword();
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
        return true;
    }
}
