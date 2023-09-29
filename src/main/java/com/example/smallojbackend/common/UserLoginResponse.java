package com.example.smallojbackend.common;

public class UserLoginResponse extends BasicResponse{
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
