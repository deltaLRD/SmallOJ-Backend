package com.example.smallojbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.smallojbackend.dao.mapper")
public class SmallOjBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmallOjBackendApplication.class, args);
    }

}
