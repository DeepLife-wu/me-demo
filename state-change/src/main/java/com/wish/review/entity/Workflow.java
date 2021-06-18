package com.wish.review.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Workflow {
    private Integer workflowId;

    private String workflowName;

    private Date createTime;

    private String createUser;

}