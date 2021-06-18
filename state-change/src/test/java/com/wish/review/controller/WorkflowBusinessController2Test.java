package com.wish.review.controller;

import com.wish.review.form.WorkflowBusinessForm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class WorkflowBusinessController2Test {

    @Autowired
    private WorkflowBusinessController workflowBusinessController;

    private String workflowBusinessId = "6";

    /**
     * 申请人-提交申请
     */
    @Test
    public void submit() {
        WorkflowBusinessForm form = new WorkflowBusinessForm();
        form.setDealUser("6");
        form.setCreateUser("6");
        form.setWorkflowId(1);
        form.setBusinessId("1");
        form.setBusinessType("A109");
        workflowBusinessController.submit(form);
    }
    @Test
    public void submit_update() {
        WorkflowBusinessForm form = new WorkflowBusinessForm();
        form.setWorkflowBusinessId(workflowBusinessId);
        form.setDealUser("6");
        form.setCreateUser("6");
        form.setWorkflowId(1);
        form.setBusinessId("1");
        form.setBusinessType("A109");
        workflowBusinessController.submit(form);
    }

    /**
     * 项目经理复核
     */
    @Test
    public void nextProjectManager() {
        WorkflowBusinessForm form = new WorkflowBusinessForm();
        form.setWorkflowBusinessId(workflowBusinessId);
        form.setDealUser("2");
        workflowBusinessController.next(form);
    }

    /**
     * 人事主管复核
     */
    @Test
    public void nextPersonManager() {
        WorkflowBusinessForm form = new WorkflowBusinessForm();
        form.setWorkflowBusinessId(workflowBusinessId);
        form.setDealUser("3");
        workflowBusinessController.next(form);
    }

    /**
     * 总经理复核
     */
    @Test
    public void nextTotalManager() {
        WorkflowBusinessForm form = new WorkflowBusinessForm();
        form.setWorkflowBusinessId(workflowBusinessId);
        form.setDealUser("4");
        workflowBusinessController.next(form);
    }

    /**
     * 财务复核
     */
    @Test
    public void nextFinancialManager() {
        WorkflowBusinessForm form = new WorkflowBusinessForm();
        form.setWorkflowBusinessId(workflowBusinessId);
        form.setDealUser("5");
        workflowBusinessController.next(form);
    }

    @Test
    public void rejectFinancialManager() {
        WorkflowBusinessForm form = new WorkflowBusinessForm();
        form.setWorkflowBusinessId(workflowBusinessId);
        form.setDealUser("5");
        workflowBusinessController.reject(form);
    }

    //申请人-项目经理-人事主管-总经理 通过，财务驳回
    @Test
    public void test01() {
        submit();
        nextProjectManager();
        nextPersonManager();
        nextTotalManager();
        rejectFinancialManager();
    }

    @Test
    public void test02() {
        submit_update();
        nextProjectManager();
        nextPersonManager();
        nextTotalManager();
        nextFinancialManager();
    }

    @Test
    public void test03() {
        submit();
        nextProjectManager();
        nextPersonManager();
        nextTotalManager();
        nextFinancialManager();
    }


}