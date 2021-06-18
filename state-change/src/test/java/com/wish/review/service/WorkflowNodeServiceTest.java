package com.wish.review.service;

import com.wish.review.entity.WorkflowNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class WorkflowNodeServiceTest {
    @Autowired
    private WorkflowNodeService workflowNodeService;

    @Test
    public void list() {
        List<WorkflowNode> list = workflowNodeService.list();
        if(CollectionUtils.isNotEmpty(list)) {
            for (WorkflowNode node : list) {
                System.out.println(node);
            }
        }
    }
}