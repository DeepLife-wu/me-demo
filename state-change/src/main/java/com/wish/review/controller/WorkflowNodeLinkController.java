package com.wish.review.controller;

import com.wish.review.dto.ActionDto;
import com.wish.review.entity.WorkflowNodeLink;
import com.wish.review.service.WorkflowNodeLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "节点流程管理")
@RestController
@RequestMapping("/workflow/node/link")
public class WorkflowNodeLinkController {
    @Autowired
    private WorkflowNodeLinkService workflowNodeLinkService;

    @ApiOperation("运行流程")
    @PostMapping("/click")
    public WorkflowNodeLink userClick(@RequestBody ActionDto actionDto) {
        return workflowNodeLinkService.queryNodeLink(actionDto);
    }

}
