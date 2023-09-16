package com.example.smallojbackend.controller;

import com.example.smallojbackend.common.AllProblemRequest;
import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.CreateProblemRequest;
import com.example.smallojbackend.dao.entity.Problem;
import com.example.smallojbackend.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problem")
public class ProblemController {
    @Autowired
    ProblemService problemService;
    @GetMapping("/")
    public BasicResponse getAllProblems(AllProblemRequest request) {
        return problemService.getAllProblem(request);
    }

    @PostMapping("/")
    public BasicResponse createProblem(CreateProblemRequest request){
        return problemService.createProblem(request);
    }

    @GetMapping("/{id}")
    public BasicResponse getProblem(@PathVariable(name = "id") Long id) {
        return problemService.getProblem(id);
    }

    @GetMapping("/{id}/md")
    public BasicResponse getProblemMd(@PathVariable(name = "id") Long id) {
        return problemService.getProblemMd(id);
    }
}
