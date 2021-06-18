package com.wish.review.dto;

import com.wish.review.consts.NodeAction;
import lombok.Data;

@Data
public class WorkflowBusinessDto {
    private String businessType;
    private Integer requestId;
    private NodeAction nodeAction;
    private String dealUserId;

}
