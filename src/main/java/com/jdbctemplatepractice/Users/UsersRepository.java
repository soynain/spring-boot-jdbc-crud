package com.jdbctemplatepractice.Users;

import java.util.List;

public interface UsersRepository {
    int saveUser(UsersEntity user);
    int updateUser(UsersEntity user);
    int deleteUser(int id);
    List<UsersEntity> getUsers();
    UsersEntity findUserById(int id);
}
