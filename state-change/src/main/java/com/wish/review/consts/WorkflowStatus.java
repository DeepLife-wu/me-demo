package com.wish.review.consts;

import lombok.Getter;

@Getter
public enum WorkflowStatus {

    PROCESS("1","处理中"),
    END("2","结束");

    WorkflowStatus(String value, String text) {
        this.value = value;
        this.text = text;
    }

    private String value;
    private String text;

}
