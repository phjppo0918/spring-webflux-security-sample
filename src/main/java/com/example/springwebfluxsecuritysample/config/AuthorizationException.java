package com.example.springwebfluxsecuritysample.config;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException() {
        super("인가 중 문제가 발생했습니다.");
    }
}
