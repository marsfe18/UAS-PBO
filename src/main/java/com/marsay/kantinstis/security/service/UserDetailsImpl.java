package com.marsay.kantinstis.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.marsay.kantinstis.entity.Pengguna;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {

    private String username;
    private String email;
    private String nama;
    @JsonIgnore
    private String passowrd;
    @JsonIgnore
    private String roles;

    public UserDetailsImpl(String username,
            String email,
            String nama,
            String passowrd,
            String roles) {
        this.username = username;
        this.email = email;
        this.nama = nama;
        this.passowrd = passowrd;
        this.roles = roles;
    }

    public static UserDetailsImpl build(Pengguna pengguna) {
        return new UserDetailsImpl(pengguna.getId(),
                pengguna.getEmail(),
                pengguna.getNama(),
                pengguna.getPassword(),
                pengguna.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (StringUtils.hasText(roles)) {
            String[] split = roles.replaceAll(" ", "").split(",");
            for (String string : split) {
                authorities.add(new SimpleGrantedAuthority(string));
            }
        }
        return authorities;

    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return passowrd;
    }

}
