package com.example.smallojbackend.common;

import java.util.List;

public class GetSubmissionResponse extends BasicResponse {
    private List<SubmissionInfo> submissionInfos;

    public List<SubmissionInfo> getSubmissionInfos() {
        return submissionInfos;
    }

    public void setSubmissionInfos(List<SubmissionInfo> submissionInfos) {
        this.submissionInfos = submissionInfos;
    }
}
