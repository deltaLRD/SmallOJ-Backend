package com.example.smallojbackend.controller;

import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.UserRegisterRequest;
import com.example.smallojbackend.dao.mapper.UserMapper;
import com.example.smallojbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public BasicResponse register(UserRegisterRequest request){
        BasicResponse response = new BasicResponse();
        response = userService.register(request);
        return response;
    }
}
