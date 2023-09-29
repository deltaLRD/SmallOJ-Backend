package com.example.smallojbackend.controller;

import com.example.smallojbackend.common.*;
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
    public BasicResponse createProblem(@RequestBody CreateProblemRequest request){
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
            @RequestBody UploadTestCaseRequest request
    ) {
        System.out.println(request.getInput());
        System.out.println(request.getAns());
        System.out.println(id);
        return problemService.uploadTestCase(id, request);
    }
}
