package com.example.smallojbackend.common;

import org.springframework.web.multipart.MultipartFile;

public class CreateProblemRequest extends BasicResponse{
    private String name;
    private String level;
    private String markdown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }
}
