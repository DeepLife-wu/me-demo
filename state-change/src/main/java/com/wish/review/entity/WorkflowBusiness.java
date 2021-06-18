package com.wish.review.entity;

import lombok.Data;

import java.util.Date;

@Data
public class WorkflowBusiness {
    private Integer workflowBusinessId;

    private Integer workflowId;

    private Integer currNode;

    private Integer lastNode;

    private String workflowStatus;

    private String businessId;

    private String businessType;

    private String dealUser;

    private String workflowIsOver;

    private String createUser;

    private Date createTime;

}