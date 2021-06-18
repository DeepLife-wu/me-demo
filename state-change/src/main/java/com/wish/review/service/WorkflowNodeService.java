package com.wish.review.service;

import com.wish.review.dao.WorkflowNodeDao;
import com.wish.review.entity.WorkflowNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowNodeService {

    @Autowired
    private WorkflowNodeDao workflowNodeDao;


    public List<WorkflowNode> list() {
        return workflowNodeDao.queryAll();
    }

}













