package com.example.smallojbackend.service;

import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.UploadSubmissionRequest;

public interface SubmissionService {
    BasicResponse submission(UploadSubmissionRequest request);
}
