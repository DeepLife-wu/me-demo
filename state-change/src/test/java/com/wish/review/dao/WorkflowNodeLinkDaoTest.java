//package com.wish.review.dao;
//
//import com.wish.review.entity.WorkflowNodeLink;
//import com.wish.review.entity.WorkflowNodeLinkKey;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@Slf4j
//@SpringBootTest
//public class WorkflowNodeLinkDaoTest {
//
//    @Autowired
//    private WorkflowNodeLinkDao workflowNodeLinkDao;
//
//    @Test
//    public void testSelectByPrimaryKey() {
//        WorkflowNodeLinkKey key = new WorkflowNodeLinkKey();
//        key.setWorkflowId(1);
//        key.setCurrNodeId(1);
//        key.setNextNodeId(2);
//        WorkflowNodeLink workflowNodeLink = workflowNodeLinkDao.selectByPrimaryKey(key);
//        log.info("" + workflowNodeLink);
//    }
//
//
//
//}
