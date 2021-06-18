package com.wish.review.consts;

import lombok.Getter;

@Getter
public enum  NodeAction {

    SUBMIT("submit","提交申请"),
    NEXT("next","通过"),
    REJECT("reject","驳回");

    NodeAction(String action,String actionText) {
        this.action = action;
        this.actionText = actionText;
    }

    private String action;
    private String actionText;

}
