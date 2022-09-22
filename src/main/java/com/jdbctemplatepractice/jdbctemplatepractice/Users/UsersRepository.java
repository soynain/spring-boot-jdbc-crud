package com.jdbctemplatepractice.jdbctemplatepractice.Users;

import java.util.List;

public interface UsersRepository {
    int saveUser(UsersEntity user);
    int updateUser(UsersEntity user,int id);
    int deleteUser(int id);
    List<UsersEntity> getUsers();
    UsersEntity findUserById(int id);
}
