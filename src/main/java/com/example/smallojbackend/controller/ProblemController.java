package com.example.smallojbackend.controller;

import com.example.smallojbackend.common.AllProblemRequest;
import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.CreateProblemRequest;
import com.example.smallojbackend.common.UploadTestCaseRequest;
import com.example.smallojbackend.dao.entity.Problem;
import com.example.smallojbackend.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/problem")
public class ProblemController {
    @Autowired
    ProblemService problemService;
    @GetMapping("/")
    public BasicResponse getAllProblems(@RequestParam("pagesize") int pagesize, @RequestParam("page") int page) {
        AllProblemRequest request = new AllProblemRequest();
        request.setPage(page);
        request.setPagesize(pagesize);
        return problemService.getAllProblem(request);
    }

    @PostMapping("/")
    public BasicResponse createProblem(@RequestParam("name") String name, @RequestParam("level") String level, @RequestParam("markdown") MultipartFile file){
        CreateProblemRequest request = new CreateProblemRequest();
        request.setLevel(level);
        request.setName(name);
        request.setMarkdown(file);
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

    @PostMapping("/{id}/testcase")
    public BasicResponse uploadTestCase(
            @PathVariable(name = "id") Long id,
            @RequestParam("type") String type,
            @RequestParam("input") MultipartFile input,
            @RequestParam("ans") MultipartFile ans
    ) {
        UploadTestCaseRequest request = new UploadTestCaseRequest();
        request.setAns(ans);
        request.setInput(input);
        request.setType(type);
        return problemService.uploadTestCase(id, request);
    }
}
