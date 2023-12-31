package com.example.smallojbackend.controller;

import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.UploadSubmissionRequest;
import com.example.smallojbackend.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submission")
public class SubmissionController {
    @Autowired
    SubmissionService submissionService;
    @PostMapping("/")
    public BasicResponse uploadSubmission(
            @RequestParam("problem_id") Long pid, @RequestParam("language") String language,
            @RequestParam("code") String code, @RequestParam("userid") String uid
    ) {
        UploadSubmissionRequest request = new UploadSubmissionRequest();
        request.setProblemId(pid);
        request.setLanguage(language);
        request.setCode(code);
        request.setUid(Long.valueOf(uid));
        return submissionService.submission(request);
    }
    @GetMapping("/")
    public BasicResponse getSubmissions() {
        return submissionService.getSubmissions();
    }
}
