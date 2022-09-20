package com.jdbctemplatepractice.Users;


public class UsersEntity {
    int id;
    String name;
    String last_name;
    int age;
    String address;
    String id_file_credential;

    public UsersEntity(int id, String name, String last_name, int age, String address, String id_file_credential) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.address = address;
        this.id_file_credential = id_file_credential;
    }

    public UsersEntity(){}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId_file_credential() {
        return this.id_file_credential;
    }

    public void setId_file_credential(String id_file_credential) {
        this.id_file_credential = id_file_credential;
    }

}
