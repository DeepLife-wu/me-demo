package com.wish.review.validate;

import com.wish.common.validator.Assert;
import com.wish.review.dto.WorkflowBusinessDto;
import com.wish.sys.dao.UserDao;
import com.wish.sys.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowNodeLinkServiceValidator {
    @Autowired
    private UserDao userDao;

    public void validate(WorkflowBusinessDto dto) {
        Assert.assertNotNull(dto,"状态不能为空");
        Assert.assertNotBlank(dto.getBusinessType(),"业务类型不能为空");
        Assert.assertNotNull(dto.getRequestId(),"申请id不能为空");
        Assert.assertNotNull(dto.getNodeAction(),"操作状态不能为空");
        Assert.assertNotBlank(dto.getDealUserId(),"操作人id不能为空");

        if(StringUtils.isNotBlank(dto.getDealUserId())) {
            User dealUserId = userDao.selectByPrimaryKey(Integer.parseInt(dto.getDealUserId()));
            Assert.assertNotNull(dealUserId,"操作人不存在");
        }
    }
}
