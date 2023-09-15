package com.example.smallojbackend.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.OffsetDateTime;

public class Submission {
    @TableId
    private Long id;
    private Long pid;
    private Long uid;
    private String language;
    private String code;
    private Integer deleted;
    @TableField("created_at")
    private OffsetDateTime createdAt;
    @TableField("updated_at")
    private OffsetDateTime updatedAt;
}
