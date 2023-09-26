package com.example.smallojbackend.common;

public class UserLoginResponse extends BasicResponse{
    private String token;

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
