package com.wish.sys.controller;

import com.google.common.collect.Lists;
import com.wish.common.utils.PageUtils;
import com.wish.common.utils.R;
import com.wish.common.validator.ValidatorUtils;
import com.wish.sys.dao.PermissionDao;
import com.wish.sys.dao.RolePermissionDao;
import com.wish.sys.entity.Permission;
import com.wish.sys.entity.Role;
import com.wish.sys.entity.RolePermissionKey;
import com.wish.sys.form.RoleForm;
import com.wish.sys.form.RoleResponse;
import com.wish.sys.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private PermissionDao permissionDao;

    @ApiOperation("角色列表")
    @PostMapping("/list")
    public R list(@RequestParam(required = false) Map<String,Object> params) {
        PageUtils page = sysRoleService.queryPage(params);
        return R.ok().put("page", page);
    }

    @ApiOperation("角色信息")
    @GetMapping("/info/{roleId}")
    public R info(@PathVariable("roleId") Integer roleId){
        Role role = sysRoleService.getById(roleId);
        RoleResponse response = new RoleResponse();
        BeanUtils.copyProperties(role,response);
        RolePermissionKey key = new RolePermissionKey();
        key.setRoleId(roleId);
        List<RolePermissionKey> rolePermissionList = rolePermissionDao.selectBy(key);
        if(CollectionUtils.isNotEmpty(rolePermissionList)) {
            List<Permission> permissionList = Lists.newArrayList();
            for (RolePermissionKey rolePermissionKey : rolePermissionList) {
                Permission permission = permissionDao.selectByPrimaryKey(rolePermissionKey.getPermissionId());
                permissionList.add(permission);
            }
            response.setPermissionList(permissionList);
        }
        return R.ok().put("role", response);
    }

    @ApiOperation("保存角色")
    @PostMapping("/save")
    public R save(@RequestBody RoleForm form){
        ValidatorUtils.validateEntity(form);
        sysRoleService.saveRole(form);
        return R.ok();
    }

    @ApiOperation("修改角色")
    @PostMapping("/update")
    public R update(@RequestBody RoleForm form){
        ValidatorUtils.validateEntity(form);
        sysRoleService.updateRole(form);
        return R.ok();
    }

    @ApiOperation("删除角色")
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] roleIds){
        sysRoleService.deleteBatch(roleIds);
        return R.ok();
    }

}
