package com.example.smallojbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.GetSubmissionResponse;
import com.example.smallojbackend.common.SubmissionInfo;
import com.example.smallojbackend.common.UploadSubmissionRequest;
import com.example.smallojbackend.dao.entity.Problem;
import com.example.smallojbackend.dao.entity.Submission;
import com.example.smallojbackend.dao.entity.User;
import com.example.smallojbackend.dao.entity.Verdict;
import com.example.smallojbackend.dao.mapper.ProblemMapper;
import com.example.smallojbackend.dao.mapper.SubmissionMapper;
import com.example.smallojbackend.dao.mapper.UserMapper;
import com.example.smallojbackend.dao.mapper.VerdictMapper;
import com.example.smallojbackend.service.SubmissionService;
import com.example.smallojbackend.utils.StatusCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    SubmissionMapper submissionMapper;
    @Autowired
    VerdictMapper verdictMapper;
    @Autowired
    ProblemMapper problemMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public BasicResponse submission(UploadSubmissionRequest request) {
        try{
            Submission submission = new Submission();
            submission.setPid(request.getProblemId());
            submission.setCode(request.getCode());
            submission.setLanguage(request.getLanguage());
            submission.setUid(request.getUid());
            submissionMapper.insert(submission);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestJson = objectMapper.writeValueAsString(submission);
            rabbitTemplate.convertAndSend("submission",requestJson);
            BasicResponse response = new BasicResponse();
            response.setStatus_msg("OK");
            response.setStatus_code(StatusCode.Success);
            return response;
        }catch (Error | JsonProcessingException e){
            e.printStackTrace();
            BasicResponse response = new BasicResponse();
            response.setStatus_msg("提交失败");
            response.setStatus_code(StatusCode.Failed);
            return response;
        }
    }

    @Override
    public BasicResponse getSubmissions() {
        try{
            QueryWrapper<Verdict> queryWrapper = new QueryWrapper<>();
            queryWrapper.groupBy("sid").select("sid, count(*), sum(status) as success_count");
            List<Verdict> verdictList = verdictMapper.selectList(queryWrapper);

            GetSubmissionResponse response = new GetSubmissionResponse();
            List<SubmissionInfo> submissionInfos = new ArrayList<>();

            for(Verdict verdict : verdictList) {
                Submission submission = submissionMapper.selectById(Long.valueOf(verdict.getSid()));
                Problem problem = problemMapper.selectById(submission.getPid());
                User user = userMapper.selectById(submission.getUid());
                SubmissionInfo submissionInfo = new SubmissionInfo();
                submissionInfo.setId(verdict.getSid());
                submissionInfo.setProblemName(problem.getName());
                submissionInfo.setPassCount(verdict.getSuccessCount());
                submissionInfo.setTestcaseCount(verdict.getCount());
                submissionInfo.setUsername(user.getUsername());
                submissionInfos.add(submissionInfo);
            }
            response.setSubmissionInfos(submissionInfos);
            response.setStatus_code(StatusCode.Success);
            response.setStatus_msg("");
            return response;
        }catch (Error e) {
            e.printStackTrace();
            BasicResponse response = new BasicResponse();
            response.setStatus_code(StatusCode.Failed);
            response.setStatus_msg("获取失败");
            return response;
        }
    }
}
