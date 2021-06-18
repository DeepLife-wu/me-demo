package com.wish.sys.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wish.sys.dao.PermissionDao;
import com.wish.sys.dao.RolePermissionDao;
import com.wish.sys.entity.Permission;
import com.wish.sys.entity.RolePermissionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionService extends ServiceImpl<PermissionDao, Permission> {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    public void delete(Integer permissionId) {
        this.removeById(permissionId);
        RolePermissionKey key = new RolePermissionKey();
        key.setPermissionId(permissionId);
        rolePermissionDao.deleteByPrimaryKey(key);
    }

}
