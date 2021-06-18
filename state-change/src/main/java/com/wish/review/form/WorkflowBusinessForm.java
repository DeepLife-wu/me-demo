package com.wish.review.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WorkflowBusinessForm {
    private String workflowBusinessId;

    @NotBlank(message="处理人不能为空")
    private String dealUser;
    private String createUser;

    private Integer workflowId;
    private String businessId;
    private String businessType;
}
