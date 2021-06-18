package com.wish.review.controller;

import com.wish.review.dto.WorkflowNodeRoleText;
import com.wish.review.entity.WorkflowNode;
import com.wish.review.entity.WorkflowNodeRole;
import com.wish.review.service.WorkflowNodeRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "节点角色管理")
@RestController
@RequestMapping("/workflow/node/role")
public class WorkflowNodeRoleController {

    @Autowired
    private WorkflowNodeRoleService workflowNodeRoleService;

    @ApiOperation("节点列表")
    @PostMapping("/list")
    public List<WorkflowNodeRole> list() {
        return workflowNodeRoleService.list();
    }

    @ApiOperation("节点文本列表")
    @PostMapping("/listText")
    public List<WorkflowNodeRoleText> listText() {
        return workflowNodeRoleService.listText();
    }

}
