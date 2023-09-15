package com.example.smallojbackend.common;

import java.util.List;

public class AllProblemResponse extends BasicResponse{
    private Long total;
    private List<ProblemBrief> problems;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<ProblemBrief> getProblems() {
        return problems;
    }

    public void setProblems(List<ProblemBrief> problems) {
        this.problems = problems;
    }
}
