package com.example.smallojbackend.service;

import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.UploadSubmissionRequest;
import com.rabbitmq.client.AMQP;

public interface SubmissionService {
    BasicResponse submission(UploadSubmissionRequest request);
    BasicResponse getSubmissions();
}
