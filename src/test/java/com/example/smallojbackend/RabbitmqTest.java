package com.example.smallojbackend;

import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.UploadSubmissionRequest;
import com.example.smallojbackend.service.SubmissionService;
import com.example.smallojbackend.utils.StatusCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitmqTest {
    @Autowired
    SubmissionService submissionService;
    @Test
    public void sendTest() {
        String language = "java";
        Long id = 1L;
        String code = """
                import java.io.*;
                import java.util.*;
                public class Main {
                    public static void main(String[] args) throws Exception{
                        Scanner cin = new Scanner(System.in);
                        int a = cin.nextInt();
                        int b = cin.nextInt();
                        System.out.print(a + b);
                    }
                }""";
        UploadSubmissionRequest request = new UploadSubmissionRequest();
        request.setCode(code);
        request.setLanguage(language);
        request.setProblemId(id);
        request.setUid(1705792757837156354L);
        BasicResponse response = submissionService.submission(request);
        Assertions.assertEquals(response.getStatus_code(), StatusCode.Success);
    }
}
