package com.example.smallojbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.smallojbackend.common.*;
import com.example.smallojbackend.dao.entity.Problem;
import com.example.smallojbackend.dao.mapper.ProblemMapper;
import com.example.smallojbackend.service.ProblemService;
import com.example.smallojbackend.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    ProblemMapper problemMapper;
    @Override
    public BasicResponse getAllProblem(AllProblemRequest request) {
        IPage<Problem> page = new Page<>(request.getPage(), request.getPagesize());
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("created_at");
        IPage<Problem> problemIPage =  problemMapper.selectPage(page,queryWrapper);
        Long total = problemIPage.getTotal();
        List<Problem> records = problemIPage.getRecords();
        List<ProblemBrief> problemBriefs = new ArrayList<>();
        for (Problem p :
                records) {
            ProblemBrief pb = new ProblemBrief();
            pb.setId(p.getId());
            pb.setName(p.getName());
            pb.setLevel(p.getLevel());
            problemBriefs.add(pb);
        }
        AllProblemResponse response = new AllProblemResponse();
        response.setStatus_code(StatusCode.Success);
        response.setStatus_msg("");
        response.setTotal(total);
        response.setProblems(problemBriefs);
        return response;
    }

    @Override
    public BasicResponse createProblem(CreateProblemRequest request) {
        try {
            Problem problem = new Problem();
            problem.setName(request.getName());
            problem.setLevel(request.getLevel());
            String markdownFile = new String();
            InputStream inputStream = request.getMarkdown().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            markdownFile = reader.lines().collect(Collectors.joining("\n"));
            problem.setDescribe(markdownFile);
            problemMapper.insert(problem);
            BasicResponse response = new BasicResponse();
            response.setStatus_code(StatusCode.Success);
            response.setStatus_msg("成功");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            BasicResponse response = new BasicResponse();
            response.setStatus_code(StatusCode.Failed);
            response.setStatus_msg("创建题目失败");
            return response;
        }

    }

    @Override
    public BasicResponse getProblem(Long id) {
        try {
            QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            Problem problem = new Problem();
            problem = problemMapper.selectOne(queryWrapper);
            GetProblemResponse response = new GetProblemResponse();
            response.setId(problem.getId());
            response.setLevel(problem.getLevel());
            response.setName(problem.getName());
            response.setStatus_code(StatusCode.Success);
            response.setStatus_msg("");
            return response;
        }catch (Exception e) {
            BasicResponse response = new BasicResponse();
            response.setStatus_code(StatusCode.Failed);
            response.setStatus_msg("");
            return response;
        }
    }

    @Override
    public BasicResponse getProblemMd(Long id) {
        try {
            QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            Problem problem = new Problem();
            problem = problemMapper.selectOne(queryWrapper);
            ProblemMdResponse response = new ProblemMdResponse();
            response.setMd(problem.getDescribe());
            response.setStatus_code(StatusCode.Success);
            response.setStatus_msg("");
            return response;
        }catch (Exception e) {
            BasicResponse response = new BasicResponse();
            response.setStatus_code(StatusCode.Failed);
            response.setStatus_msg("");
            return response;
        }
    }
}
