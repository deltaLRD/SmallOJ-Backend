package com.example.smallojbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.UserRegisterRequest;
import com.example.smallojbackend.common.UserRegisterResponse;
import com.example.smallojbackend.dao.entity.User;
import com.example.smallojbackend.dao.mapper.UserMapper;
import com.example.smallojbackend.service.UserService;
import com.example.smallojbackend.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public BasicResponse register(UserRegisterRequest request) {
        UserRegisterResponse response = new UserRegisterResponse();

        User user = new User();

        // 查询用户名是否已经存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", request.getUsername());
        user = userMapper.selectOne(queryWrapper);
        if(user != null) {
            response.setStatus_code(StatusCode.RegisterFailed);
            response.setStatus_msg("用户名已经被注册");
            return response;
        }

        user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        int lines = userMapper.insert(user);
        response.setStatus_code(StatusCode.Success);
        response.setStatus_msg("");
        if (lines != 1){
            response.setStatus_code(StatusCode.Failed);
            response.setStatus_msg("注册失败");
        }
        return response;
    }
}
