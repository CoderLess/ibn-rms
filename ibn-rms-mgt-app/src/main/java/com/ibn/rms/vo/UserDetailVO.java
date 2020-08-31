package com.ibn.rms.vo;

import com.google.common.collect.Lists;
import com.ibn.rms.domain.UserBaseDTO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.vo
 * @author： RenBin
 * @createTime：2020/8/14 10:08
 */
@Data
public class UserDetailVO implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * 通过 user 对象创建jwtUser
     */
    public UserDetailVO(UserBaseDTO userBaseDTO) {
        id = userBaseDTO.getId();
        username = userBaseDTO.getUsername();
        password = userBaseDTO.getPassword();
        enabled = true;
        authorities = Lists.newArrayList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
