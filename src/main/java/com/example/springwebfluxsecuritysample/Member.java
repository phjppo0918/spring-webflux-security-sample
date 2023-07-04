package com.example.springwebfluxsecuritysample;

import lombok.Getter;

import java.util.List;

@Getter
public class Member {
    private String id;
    private List<String> roles;

    public Member(final String id, final List<String> roles) {
        this.id = id;
        this.roles = roles;
    }
}
