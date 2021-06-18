package com.wish.review.consts;

import lombok.Getter;

@Getter
public enum  NodeStatus {

    START("1","起始节点"),
    PROCESS("2","流程中间节点"),
    END("3","结束节点");

    NodeStatus(String value,String text) {
        this.value = value;
        this.text = text;
    }

    private String value;
    private String text;

}
