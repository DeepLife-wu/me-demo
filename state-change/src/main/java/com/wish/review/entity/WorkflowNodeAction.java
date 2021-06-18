package com.wish.review.entity;

import lombok.Data;

@Data
public class WorkflowNodeAction {
    private Integer id;

    private Integer workflowId;

    private Integer nodeId;

    private String action;

    private String actionName;

}