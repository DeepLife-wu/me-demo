package com.wish.review.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class WorkflowNode {
    private Integer nodeId;

    private Integer workflowId;

    private String nodeName;

    private String nodeStatus;

    private Date createTime;

    private String createUser;

}