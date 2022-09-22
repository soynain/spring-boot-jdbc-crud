package com.jdbctemplatepractice.jdbctemplatepractice.Login;

public class LoginForm {
    public String username;
    public String password;


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginForm username(String username) {
        setUsername(username);
        return this;
    }

    public LoginForm password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}

   
