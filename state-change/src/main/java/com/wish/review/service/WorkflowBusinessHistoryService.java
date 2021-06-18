package com.wish.review.service;

import com.wish.common.validator.Assert;
import com.wish.review.dao.WorkflowBusinessHistoryDao;
import com.wish.review.dto.WorkflowBusinessDto;
import com.wish.review.entity.WorkflowBusiness;
import com.wish.review.entity.WorkflowBusinessHistory;
import com.wish.sys.dao.UserDao;
import com.wish.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WorkflowBusinessHistoryService {
    @Autowired
    private WorkflowBusinessHistoryDao workflowBusinessHistoryDao;
    @Autowired
    private UserDao userDao;

    public void history(WorkflowBusinessDto workflowBusinessDto,WorkflowBusiness workflowBusiness) {
        Assert.assertNotNull(workflowBusiness,"业务申请不能为空");
        WorkflowBusinessHistory entity = new WorkflowBusinessHistory();
        entity.setWorkflowBusinessId(workflowBusiness.getWorkflowBusinessId());
        entity.setCurrNodeId(String.valueOf(workflowBusiness.getLastNode()));
        entity.setNextNodeId(String.valueOf(workflowBusiness.getCurrNode()));
        entity.setNodeAction(workflowBusinessDto.getNodeAction().getAction());

        String userId = workflowBusiness.getDealUser();
        entity.setDealUserId(userId);
        User user = userDao.selectByPrimaryKey(Integer.parseInt(userId));
        if(user!= null) {
            entity.setDealUserName(user.getUsername());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        entity.setDealTime(sdf.format(new Date()));
        entity.setSuggestionFeedback(workflowBusinessDto.getNodeAction().getActionText());
        entity.setDealStep(workflowBusinessDto.getNodeAction().getActionText());
        entity.setCreateTime(sdf.format(new Date()));
        entity.setCreateUser(userId);
        workflowBusinessHistoryDao.insert(entity);
    }
}
