package com.example.smallojbackend.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@TableName("verdicts")
public class Verdict {
    @TableId
    private Long id;
    private Long sid;
    private Long tid;
    private Long status;
    @TableField("exec_time")
    private Long execTime;
    private Integer deleted;
    @TableField("created_at")
    private OffsetDateTime createdAt;
    @TableField("updated_at")
    private OffsetDateTime updatedAt;
}
