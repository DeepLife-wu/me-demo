package com.wish.review.controller;

import com.wish.review.form.WorkflowBusinessForm;
import com.wish.review.service.WorkflowBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "业务流程管理")
@RestController
@RequestMapping("/workflow/business")
public class WorkflowBusinessController {

    @Autowired
    private WorkflowBusinessService workflowBusinessService;

    @ApiOperation("提交流程")
    @PostMapping("/action/submit")
    public void submit(@RequestBody WorkflowBusinessForm form) {
        workflowBusinessService.submit(form);
    }

    @ApiOperation("审核通过")
    @PostMapping("/action/next")
    public void next(@RequestBody WorkflowBusinessForm form) {
        workflowBusinessService.next(form);
    }

    @ApiOperation("审核拒绝")
    @PostMapping("/action/reject")
    public void reject(@RequestBody WorkflowBusinessForm form) {
        workflowBusinessService.reject(form);
    }

}
