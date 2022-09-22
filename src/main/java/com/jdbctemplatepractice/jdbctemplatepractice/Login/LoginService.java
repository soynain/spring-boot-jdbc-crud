package com.jdbctemplatepractice.jdbctemplatepractice.Login;

public interface LoginService {
    LoginForm getCredentials(String username,String password);
}
