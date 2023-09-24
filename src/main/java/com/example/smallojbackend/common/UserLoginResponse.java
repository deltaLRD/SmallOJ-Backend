package com.example.smallojbackend.common;

public class UserLoginResponse extends BasicResponse{
    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
