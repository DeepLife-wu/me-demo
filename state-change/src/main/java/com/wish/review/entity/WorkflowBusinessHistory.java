package com.wish.review.entity;

import lombok.Data;

@Data
public class WorkflowBusinessHistory {
    private Integer historyId;

    private Integer workflowBusinessId;

    private String currNodeId;

    private String nextNodeId;

    private String nodeAction;

    private String dealUserId;

    private String dealUserName;

    private String dealTime;

    private String dealStep;

    private String createTime;

    private String createUser;

    private String suggestionFeedback;

}