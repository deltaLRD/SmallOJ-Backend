package com.example.smallojbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smallojbackend.common.*;
import com.example.smallojbackend.dao.entity.User;
import com.example.smallojbackend.dao.mapper.UserMapper;
import com.example.smallojbackend.service.UserService;
import com.example.smallojbackend.utils.StatusCode;
import com.example.smallojbackend.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    Token tokenFactory;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
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

    @Override
    public BasicResponse login(UserLoginRequest request) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", request.getUsername());
        User user = new User();
        user = userMapper.selectOne(queryWrapper);
        if(user == null){
            BasicResponse response = new BasicResponse();
            response.setStatus_code(StatusCode.Failed);
            response.setStatus_msg("登录失败,用户不存在");
            return response;
        }
        if(!user.getPassword().equals(request.getPassword())){
            BasicResponse response = new BasicResponse();
            response.setStatus_code(StatusCode.Failed);
            response.setStatus_msg("登录失败,密码错误");
            return response;
        }

        String token = tokenFactory.createToken(user.getId());
        redisTemplate.boundValueOps(user.getId().toString()).set(token);
        UserLoginResponse response = new UserLoginResponse();
        response.setStatus_code(StatusCode.Success);
        response.setStatus_msg("");
        response.setToken(token);
        return response;
    }
}
