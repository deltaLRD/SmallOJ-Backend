package com.example.smallojbackend.service;

import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.UserLoginRequest;
import com.example.smallojbackend.common.UserLoginResponse;
import com.example.smallojbackend.common.UserRegisterRequest;
import org.springframework.stereotype.Service;


public interface UserService {
    BasicResponse register(UserRegisterRequest request);
    BasicResponse login(UserLoginRequest request);
}
