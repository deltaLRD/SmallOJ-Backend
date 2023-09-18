package com.example.smallojbackend.service;

import com.example.smallojbackend.common.AllProblemRequest;
import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.CreateProblemRequest;
import com.example.smallojbackend.common.UploadTestCaseRequest;

public interface ProblemService {
    BasicResponse getAllProblem(AllProblemRequest request);
    BasicResponse createProblem(CreateProblemRequest request);
    BasicResponse getProblem(Long id);
    BasicResponse getProblemMd(Long id);
    BasicResponse uploadTestCase(Long id, UploadTestCaseRequest request);
}
