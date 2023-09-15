package com.example.smallojbackend.controller;

import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.dao.entity.Problem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/problem")
public class ProblemController {
    @GetMapping("/")
    public BasicResponse getAllProblems() {
        return null;
    }
}
