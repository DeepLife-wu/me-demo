package com.wish.review.service;

import com.wish.common.exception.RRException;
import com.wish.review.consts.CommonConst;
import com.wish.review.dao.WorkflowBusinessDao;
import com.wish.review.dao.WorkflowNodeLinkDao;
import com.wish.review.dto.ActionDto;
import com.wish.review.dto.WorkflowBusinessDto;
import com.wish.review.entity.WorkflowBusiness;
import com.wish.review.entity.WorkflowNodeLink;
import com.wish.review.validate.WorkflowNodeLinkServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowNodeLinkService {

    @Autowired
    private WorkflowNodeLinkDao workflowNodeLinkDao;
    @Autowired
    private WorkflowBusinessDao workflowBusinessDao;
    @Autowired
    private WorkflowNodeLinkServiceValidator workflowNodeLinkServiceValidator;
    @Autowired
    private WorkflowBusinessHistoryService workflowBusinessHistoryService;

    public WorkflowNodeLink queryNodeLink(ActionDto actionDto) {
        WorkflowNodeLink nodeLink = workflowNodeLinkDao.queryNodeLink(actionDto);
        return nodeLink;
    }
    //状态变更
    public void action(WorkflowBusinessDto dto) {
        workflowNodeLinkServiceValidator.validate(dto);
        WorkflowBusiness workflowBusiness = workflowBusinessDao.lockByPrimaryKey(dto.getRequestId());
        if(workflowBusiness == null) {
            throw new RRException("业务申请不存在");
        }

        ActionDto actionDto = buildActionDto(dto.getNodeAction().getAction(), workflowBusiness);
        WorkflowNodeLink nextNode = workflowNodeLinkDao.queryNodeLink(actionDto);
        if(nextNode == null) {
            throw new RRException("不存在的流程->" + nextNode);
        }
        workflowBusiness.setLastNode(workflowBusiness.getCurrNode());
        workflowBusiness.setCurrNode(nextNode.getNextNodeId());
        workflowBusiness.setDealUser(dto.getDealUserId());

        if("2".equals(nextNode.getWorkflowStatus())) {
            workflowBusiness.setWorkflowIsOver(CommonConst.TRUE);
            workflowBusiness.setWorkflowStatus("2");
        }
        workflowBusinessDao.updateByPrimaryKey(workflowBusiness);
        workflowBusinessHistoryService.history(dto,workflowBusiness);
    }

    private ActionDto buildActionDto(String action, WorkflowBusiness workflowBusiness) {
        ActionDto actionDto = new ActionDto();
        actionDto.setNodeId(String.valueOf(workflowBusiness.getCurrNode()));
        actionDto.setAction(action);
        return actionDto;
    }

}
