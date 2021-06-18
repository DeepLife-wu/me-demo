package com.wish.sys.validate;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wish.common.exception.RRException;
import com.wish.common.utils.Constant;
import com.wish.sys.entity.Permission;
import com.wish.sys.form.PermissionForm;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PermissionValidator {
    private List<String> permissionTypeList = Arrays.asList(
            Constant.MenuType.BUTTON.getValue() + "",
            Constant.MenuType.MENU.getValue() + ""
    );

    public Permission validate(PermissionForm form) {
        if(StringUtils.isBlank(form.getName())) {
            throw new RRException("名称不能为空");
        }

        if(StringUtils.isBlank(form.getType())) {
            throw new RRException("类型不能为空");
        }

        if(!permissionTypeList.contains(form.getType())) {
            throw new RRException("不支持的类型");
        }

        if(StringUtils.isBlank(form.getAction())) {
            throw new RRException("链接不能为空");
        }
        Permission permission = new Permission();
        BeanUtils.copyProperties(form,permission);
        return permission;
    }
}
