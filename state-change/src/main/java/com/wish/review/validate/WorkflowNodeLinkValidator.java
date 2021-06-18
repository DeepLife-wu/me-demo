package com.wish.review.validate;

import com.wish.common.validator.Assert;
import com.wish.review.consts.NodeAction;
import com.wish.review.dto.ActionDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WorkflowNodeLinkValidator {
    private static List<NodeAction> NODE_ACTION_LIST = Arrays.asList(NodeAction.values());

    public void validate(ActionDto actionDto) {
        Assert.assertNotNull(actionDto,"操作对象不能为空");
        Assert.assertNotBlank(actionDto.getNodeId(),"节点id不能为空");
        Assert.assertNotBlank(actionDto.getAction(),"操作不能为空");
        assertActionEquals(actionDto.getAction());
        Assert.assertNotBlank(actionDto.getUserId(),"用户id不能为空");
    }

    private void assertActionEquals(String actionId) {
        boolean exists = false;
        for(NodeAction nodeAction : NODE_ACTION_LIST) {
            if(nodeAction.getAction().equals(actionId)) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists,"不存在的操作");
    }

}
