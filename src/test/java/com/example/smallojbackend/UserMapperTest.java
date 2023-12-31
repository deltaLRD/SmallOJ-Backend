package com.example.smallojbackend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smallojbackend.dao.entity.User;
import com.example.smallojbackend.dao.mapper.UserMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    @Order(1)
    void createUser(){
        User user = new User();
        user.setUsername("Lird2002");
        user.setEmail("ruidongli2002@gmail.com");
        user.setPassword("balabala2023");

        userMapper.insert(user);
    }
    @Test
    @Order(2)
    void getUser(){
        User user = new User();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "Lird2002");
        user = userMapper.selectOne(queryWrapper);
        Assertions.assertEquals(user.getEmail(),"ruidongli2002@gmail.com");
        Assertions.assertEquals(user.getPassword(),"balabala2023");
    }

    @Test
    @Order(3)
    void updateTest(){
        User user = new User();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "Lird2002");
        user = userMapper.selectOne(queryWrapper);
        user.setEmail("admin@admin.com");
        userMapper.updateById(user);
        user = userMapper.selectOne(queryWrapper);
        Assertions.assertEquals(user.getEmail(),"admin@admin.com");
        Assertions.assertEquals(user.getPassword(), "balabala2023");
    }

    @Test
    @Order(4)
    void delTest(){
        User user = new User();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "Lird2002");
        user = userMapper.selectOne(queryWrapper);
        userMapper.deleteById(user);
        user = userMapper.selectOne(queryWrapper);
        Assertions.assertEquals(user, null);
    }
}
