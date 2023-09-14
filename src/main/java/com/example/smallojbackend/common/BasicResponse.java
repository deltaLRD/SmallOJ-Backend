package com.example.smallojbackend.common;

import com.example.smallojbackend.utils.StatusCode;

public class BasicResponse {
    private StatusCode status_code;
    private String status_msg;

    public StatusCode getStatus_code() {
        return status_code;
    }

    public void setStatus_code(StatusCode status_code) {
        this.status_code = status_code;
    }

    public String getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(String status_msg) {
        this.status_msg = status_msg;
    }
}
