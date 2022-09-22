package com.jdbctemplatepractice.jdbctemplatepractice.Login;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginRowMapper implements RowMapper<LoginForm>{

    @Override
    public LoginForm mapRow(ResultSet rs, int rowNum) throws SQLException {
        LoginForm credentialToBeReturned=new LoginForm();
        credentialToBeReturned.setUsername(rs.getString("username"));
        credentialToBeReturned.setPassword(rs.getString("password"));
        return credentialToBeReturned;
    }
    
}
