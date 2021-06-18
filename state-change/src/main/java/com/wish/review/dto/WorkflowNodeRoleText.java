package com.wish.review.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class WorkflowNodeRoleText {
    private Integer nodeId;
    private Integer roleId;

    private String nodeText;
    private String roleText;
}
