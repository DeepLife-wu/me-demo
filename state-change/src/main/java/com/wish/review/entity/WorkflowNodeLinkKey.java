package com.wish.review.entity;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class WorkflowNodeLinkKey {
    private Integer workflowId;

    private Integer currNodeId;

    private Integer nextNodeId;

}