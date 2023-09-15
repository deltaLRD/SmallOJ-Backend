package com.example.smallojbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.smallojbackend.common.*;
import com.example.smallojbackend.dao.entity.Problem;
import com.example.smallojbackend.dao.mapper.ProblemMapper;
import com.example.smallojbackend.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        response.setTotal(total);
        response.setProblems(problemBriefs);
        return response;
    }

    @Override
    public BasicResponse createProblem(CreateProblemRequest request) {
        return null;
    }
}
