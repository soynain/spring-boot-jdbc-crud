package com.jdbctemplatepractice.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<UsersEntity> {

    @Override
    public UsersEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsersEntity users=new UsersEntity(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("last_name"),
            rs.getInt("age"),
            rs.getString("address"),
            rs.getString("id_file_credential")
        );
        return users;
    }
    
}
