package com.wish.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wish.common.utils.PageUtils;
import com.wish.common.utils.Query;
import com.wish.sys.dao.RoleDao;
import com.wish.sys.dao.RolePermissionDao;
import com.wish.sys.dao.UserRoleDao;
import com.wish.sys.entity.Role;
import com.wish.sys.entity.RolePermissionKey;
import com.wish.sys.entity.UserRoleKey;
import com.wish.sys.form.RoleForm;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleService extends ServiceImpl<RoleDao, Role> {
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private UserRoleDao userRoleDao;

    public PageUtils queryPage(Map<String, Object> params) {
        String roleName = (String)params.get("name");

        IPage<Role> page = this.page(
                new Query<Role>().getPage(params),
                new QueryWrapper<Role>()
                        .like(StringUtils.isNotBlank(roleName),"name", roleName)
        );

        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveRole(RoleForm form) {
        Role role = new Role();
        BeanUtils.copyProperties(form,role);
        this.save(role);

        assignRolePermission(form, role);
    }

    private void assignRolePermission(RoleForm form, Role role) {
        RolePermissionKey key = new RolePermissionKey();
        key.setRoleId(role.getRoleId());
        rolePermissionDao.deleteByPrimaryKey(key);
        List<Integer> permissionList = form.getPermissionList();
        if(CollectionUtils.isNotEmpty(permissionList)) {
            for(Integer permissionId: permissionList) {
                RolePermissionKey rolePermission = new RolePermissionKey();
                rolePermission.setRoleId(role.getRoleId());
                rolePermission.setPermissionId(permissionId);
                rolePermissionDao.insert(rolePermission);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateRole(RoleForm form) {
        Role role = new Role();
        BeanUtils.copyProperties(form,role);
        this.updateById(role);

        assignRolePermission(form, role);
    }

    public void deleteBatch(Integer[] roleIds) {
        this.removeByIds(Arrays.asList(roleIds));

        deleteRolePermission(roleIds);
        deleteUserRole(roleIds);
    }

    private void deleteRolePermission(Integer[] roleIds) {
        if(roleIds != null && roleIds.length > 0) {
            for (Integer roleId : roleIds) {
                RolePermissionKey rolePermissionKey = new RolePermissionKey();
                rolePermissionKey.setRoleId(roleId);
                rolePermissionDao.deleteByPrimaryKey(rolePermissionKey);
            }
        }
    }

    private void deleteUserRole(Integer[] roleIds) {
        if(roleIds != null && roleIds.length > 0) {
            for (Integer roleId : roleIds) {
                UserRoleKey userRoleKey = new UserRoleKey();
                userRoleKey.setRoleId(roleId);
                userRoleDao.deleteByPrimaryKey(userRoleKey);
            }
        }
    }
}
