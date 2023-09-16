package com.example.smallojbackend.common;

public class UserLoginResponse extends BasicResponse{
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
