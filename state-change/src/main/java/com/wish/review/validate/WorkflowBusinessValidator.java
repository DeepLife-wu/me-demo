package com.wish.review.validate;

import com.wish.common.validator.Assert;
import com.wish.review.form.WorkflowBusinessForm;
import com.wish.sys.dao.UserDao;
import com.wish.sys.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowBusinessValidator {

    @Autowired
    private UserDao userDao;

    public void validate(WorkflowBusinessForm form) {
        Assert.assertNotBlank(form.getDealUser(),"处理人不能为空");
        User dealUser = userDao.selectByPrimaryKey(Integer.parseInt(form.getDealUser()));
        Assert.assertNotNull(dealUser,"该处理人不存在");
        if(StringUtils.isNotBlank(form.getCreateUser())) {
            User createUser = userDao.selectByPrimaryKey(Integer.parseInt(form.getCreateUser()));
            Assert.assertNotNull(createUser,"创建人不存在");
        }
    }


}
