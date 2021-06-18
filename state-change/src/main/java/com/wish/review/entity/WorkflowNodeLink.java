package com.wish.review.entity;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class WorkflowNodeLink extends WorkflowNodeLinkKey {
    private String actionName;

    private String action;

    private String workflowStatus;

}