package com.jwtexample.jwtdemo.Config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwtexample.jwtdemo.model.User;

public class CostumUserDetails implements UserDetails {

    @Autowired
    private User user;

    public CostumUserDetails(User user){
        this.user = user;
    }

    // this for the without role base authentication
    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(getPassword());
    //     return List.of(simpleGrantedAuthority);
    // }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRole().name()));
    }
    
    // If you create Role class then use this 
    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     List<SimpleGrantedAuthority> athories = user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    //     return athories;
    // }
    
}
