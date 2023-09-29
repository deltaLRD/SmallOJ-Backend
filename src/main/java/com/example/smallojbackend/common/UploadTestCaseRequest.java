package com.example.smallojbackend.common;

import org.springframework.web.multipart.MultipartFile;

public class UploadTestCaseRequest {
    private String type;
    private String input;
    private String ans;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
