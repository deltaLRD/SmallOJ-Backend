package com.example.smallojbackend.dao.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    @TableLogic
    private Integer deleted;
}
