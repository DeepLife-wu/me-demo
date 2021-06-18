package com.wish.review.service;

import com.alibaba.fastjson.JSON;
import com.wish.review.consts.NodeAction;
import com.wish.review.dto.ActionDto;
import com.wish.review.entity.WorkflowNodeLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class WorkflowNodeLinkServiceTest {

    @Autowired
    private WorkflowNodeLinkService workflowNodeLinkService;

    @Test
    public void queryNodeLink() {
        ActionDto dto = new ActionDto();
        dto.setNodeId("1");
        dto.setAction(NodeAction.SUBMIT.getAction());
        WorkflowNodeLink nodeLink = workflowNodeLinkService.queryNodeLink(dto);
        System.out.println(JSON.toJSON(nodeLink));
    }

}