package com.example.smallojbackend.service;

import com.example.smallojbackend.common.AllProblemRequest;
import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.CreateProblemRequest;

public interface ProblemService {
    BasicResponse getAllProblem(AllProblemRequest request);
    BasicResponse createProblem(CreateProblemRequest request);
}
