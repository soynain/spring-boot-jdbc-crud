package com.jdbctemplatepractice.jdbctemplatepractice.Users;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UsersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveUser(UsersEntity user) {
        return jdbcTemplate.update("INSERT INTO jdbcpractice VALUES(null,?,?,?,?,?)",
            user.getName(),
            user.getLast_name(),
            user.getAge(),
            user.getAddress(),
            user.getId_file_credential());
    }

    @Override
    public int updateUser(UsersEntity user,int id) {
        return jdbcTemplate.update(
            "UPDATE jdbcpractice SET name=?,last_name=?,age=?,address=?,id_file_credential=? where id=?",
            user.getName(), user.getLast_name(), user.getAge(), user.getAddress(), user.getId_file_credential(),id);
    }

    @Override
    public int deleteUser(int id) {
        return jdbcTemplate.update("delete from jdbcpractice where id=?", id);
    }

    @Override
    public List<UsersEntity> getUsers() {
        return jdbcTemplate.query("select * from jdbcpractice", new UsersRowMapper());
    }

    @Override
    public UsersEntity findUserById(int id) {
        return jdbcTemplate.queryForObject("select * from jdbcpractice where id=?", new UsersRowMapper(), id);
    }

}
