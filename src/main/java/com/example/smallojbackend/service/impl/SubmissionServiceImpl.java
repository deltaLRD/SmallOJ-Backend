package com.example.smallojbackend.service.impl;

import com.example.smallojbackend.common.BasicResponse;
import com.example.smallojbackend.common.UploadSubmissionRequest;
import com.example.smallojbackend.service.SubmissionService;
import com.example.smallojbackend.utils.StatusCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    public BasicResponse submission(UploadSubmissionRequest request) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String requestJson = objectMapper.writeValueAsString(request);
//            Message message = new Message(requestJson.getBytes());
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
}
