package com.example.smallojbackend;

import com.example.smallojbackend.dao.entity.User;
import com.example.smallojbackend.utils.Token;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private Token tokenFactory;
    @Test
    void redisTest(){
        String username = "Lird2002";
        String token = new String();
        token = tokenFactory.createToken("12315324-13515-1551");
        redisTemplate.boundValueOps(token).set(username);
    }
}
