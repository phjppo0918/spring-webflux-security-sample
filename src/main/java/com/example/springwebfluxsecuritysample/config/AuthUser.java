package com.example.springwebfluxsecuritysample.config;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class AuthUser extends UsernamePasswordAuthenticationToken {
    public AuthUser(String name) {
        super(name, null, toAuthority(List.of("USER")));
    }

    private static List<SimpleGrantedAuthority> toAuthority(List<String> roles) {
        return roles.stream().map(SimpleGrantedAuthority::new).toList();
    }
}
