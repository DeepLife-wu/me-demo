package com.wish.review.service;

import com.wish.review.consts.CommonConst;
import com.wish.review.consts.NodeAction;
import com.wish.review.consts.WorkflowStatus;
import com.wish.review.dao.WorkflowBusinessDao;
import com.wish.review.dto.WorkflowBusinessDto;
import com.wish.review.entity.WorkflowBusiness;
import com.wish.review.form.WorkflowBusinessForm;
import com.wish.review.validate.WorkflowBusinessValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class WorkflowBusinessService {
    @Autowired
    private WorkflowBusinessDao workflowBusinessDao;
    @Autowired
    private WorkflowBusinessValidator workflowBusinessValidator;
    @Autowired
    private WorkflowNodeLinkService workflowNodeLinkService;

    @Transactional
    public void submit(WorkflowBusinessForm form) {
        workflowBusinessValidator.validate(form);
        WorkflowBusiness workflowBusiness = null;
        if(StringUtils.isBlank(form.getWorkflowBusinessId())) { //为空就是新增，否则是更新
            workflowBusiness = new WorkflowBusiness();
            setEntityValue(form, workflowBusiness);
            workflowBusiness.setCreateTime(new Date());
            workflowBusinessDao.insert(workflowBusiness);
        } else {
            workflowBusiness = workflowBusinessDao.selectByPrimaryKey(Integer.parseInt(form.getWorkflowBusinessId()));
            setEntityValue(form, workflowBusiness);
            workflowBusinessDao.updateByPrimaryKey(workflowBusiness);
        }
        WorkflowBusinessDto dto = buildWorkflowBusinessDto(workflowBusiness);
        workflowNodeLinkService.action(dto);
    }

    private WorkflowBusinessDto buildWorkflowBusinessDto(WorkflowBusiness workflowBusiness) {
        WorkflowBusinessDto dto = new WorkflowBusinessDto();
        dto.setBusinessType(workflowBusiness.getBusinessType());
        dto.setRequestId(workflowBusiness.getWorkflowBusinessId());
        dto.setDealUserId(workflowBusiness.getDealUser());
        dto.setNodeAction(NodeAction.SUBMIT);
        return dto;
    }

    private void setEntityValue(WorkflowBusinessForm form, WorkflowBusiness workflowBusiness) {
        workflowBusiness.setCurrNode(1);                    //当前结点是申请人
        workflowBusiness.setWorkflowStatus(WorkflowStatus.PROCESS.getValue());
        workflowBusiness.setWorkflowIsOver(CommonConst.FALSE);

        workflowBusiness.setDealUser(form.getDealUser());
        workflowBusiness.setCreateUser(form.getCreateUser());
        workflowBusiness.setWorkflowId(form.getWorkflowId());
        workflowBusiness.setBusinessId(form.getBusinessId());
        workflowBusiness.setBusinessType(form.getBusinessType());
    }


    public void next(WorkflowBusinessForm form) {
        workflowBusinessValidator.validate(form);
        WorkflowBusiness workflowBusiness = workflowBusinessDao.selectByPrimaryKey(Integer.parseInt(form.getWorkflowBusinessId()));
        WorkflowBusinessDto dto = buildWorkflowBusinessDto(workflowBusiness);
        dto.setNodeAction(NodeAction.NEXT);
        dto.setDealUserId(form.getDealUser());
        workflowNodeLinkService.action(dto);
    }

    public void reject(WorkflowBusinessForm form) {
        workflowBusinessValidator.validate(form);
        WorkflowBusiness workflowBusiness = workflowBusinessDao.selectByPrimaryKey(Integer.parseInt(form.getWorkflowBusinessId()));
        WorkflowBusinessDto dto = buildWorkflowBusinessDto(workflowBusiness);
        dto.setNodeAction(NodeAction.REJECT);
        workflowNodeLinkService.action(dto);
    }
}
