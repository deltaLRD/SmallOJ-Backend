package com.example.smallojbackend.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadSubmissionRequest {
    private String problemId;
    private String language;
    private String code;

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
