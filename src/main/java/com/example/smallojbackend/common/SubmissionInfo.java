package com.example.smallojbackend.common;

public class SubmissionInfo {
    private String username;
    private String problemName;
    private Long testcaseCount;
    private Long passCount;
    private String id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public Long getTestcaseCount() {
        return testcaseCount;
    }

    public void setTestcaseCount(Long testcaseCount) {
        this.testcaseCount = testcaseCount;
    }

    public Long getPassCount() {
        return passCount;
    }

    public void setPassCount(Long passCount) {
        this.passCount = passCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
