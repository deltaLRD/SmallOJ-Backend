package com.example.smallojbackend.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadSubmissionRequest {
    private Long problemId;
    private String language;
    private String code;
    private Long uid;

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
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

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
