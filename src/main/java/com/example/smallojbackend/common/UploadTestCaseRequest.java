package com.example.smallojbackend.common;

import org.springframework.web.multipart.MultipartFile;

public class UploadTestCaseRequest {
    private String type;
    private MultipartFile input;
    private MultipartFile ans;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getInput() {
        return input;
    }

    public void setInput(MultipartFile input) {
        this.input = input;
    }

    public MultipartFile getAns() {
        return ans;
    }

    public void setAns(MultipartFile ans) {
        this.ans = ans;
    }
}
