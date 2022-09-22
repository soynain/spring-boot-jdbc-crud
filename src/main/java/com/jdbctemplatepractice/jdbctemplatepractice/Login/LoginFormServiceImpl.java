package com.jdbctemplatepractice.jdbctemplatepractice.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginFormServiceImpl implements LoginService{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public LoginForm getCredentials(String username,String password) {
        return jdbcTemplate.queryForObject("select * from credentials where username=? and password=?", new LoginRowMapper(),username,password);
    }
    
}
