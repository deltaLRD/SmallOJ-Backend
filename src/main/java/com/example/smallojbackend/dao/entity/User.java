package com.example.smallojbackend.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("users")
public class User {
    @TableId
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer deleted;
}
