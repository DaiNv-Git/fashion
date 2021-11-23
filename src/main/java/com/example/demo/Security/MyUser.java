package com.example.demo.Security;

import com.example.demo.Model.Roles;
import com.example.demo.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUser implements UserDetails {
    @Autowired
    private Users user;
    public MyUser(Users user){
        this.user=user;
    }
//tra ve role name
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Roles> roles = (Set<Roles>) user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Roles role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
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
        return true;
    }
}
