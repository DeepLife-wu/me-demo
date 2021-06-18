package com.wish.review.service;

import com.wish.review.dto.WorkflowNodeRoleText;
import com.wish.review.entity.WorkflowNodeRole;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class WorkflowNodeRoleServiceTest {
    @Autowired
    private WorkflowNodeRoleService workflowNodeRoleService;

    @Test
    public void list() {
        List<WorkflowNodeRole> list = workflowNodeRoleService.list();
        if(CollectionUtils.isNotEmpty(list))
        {
            for (WorkflowNodeRole nodeRole:list) {
                System.out.println(nodeRole);
            }
        }
    }

    @Test
    public void listText() {
        List<WorkflowNodeRoleText> workflowNodeRoleTexts = workflowNodeRoleService.listText();
        if(CollectionUtils.isNotEmpty(workflowNodeRoleTexts)) {
            for (WorkflowNodeRoleText nodeRoleText:workflowNodeRoleTexts) {
                System.out.println(nodeRoleText);
            }
        }
    }
}