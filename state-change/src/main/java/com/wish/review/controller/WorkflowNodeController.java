package com.wish.review.controller;

import com.wish.review.entity.WorkflowNode;
import com.wish.review.service.WorkflowNodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "节点管理")
@RestController
@RequestMapping("/workflow/node")
public class WorkflowNodeController {

    @Autowired
    private WorkflowNodeService workflowNodeService;

    @ApiOperation("节点列表")
    @PostMapping("/list")
    public List<WorkflowNode> list() {
        return workflowNodeService.list();
    }

}
