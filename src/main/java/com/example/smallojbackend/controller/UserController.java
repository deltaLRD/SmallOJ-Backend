package com.example.smallojbackend.controller;

import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.UserLoginRequest;
import com.example.smallojbackend.common.UserLoginResponse;
import com.example.smallojbackend.common.UserRegisterRequest;
import com.example.smallojbackend.dao.mapper.UserMapper;
import com.example.smallojbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public BasicResponse register(@RequestBody UserRegisterRequest request){
        BasicResponse response = new BasicResponse();
        response = userService.register(request);
        return response;
    }

    @GetMapping(value = "/login")
    public BasicResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserLoginRequest request = new UserLoginRequest();
        request.setUsername(username);
        request.setPassword(password);
        return userService.login(request);
    }
}
