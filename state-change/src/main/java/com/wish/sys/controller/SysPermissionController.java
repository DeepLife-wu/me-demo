package com.wish.sys.controller;

import com.wish.common.exception.RRException;
import com.wish.common.utils.R;
import com.wish.sys.entity.Permission;
import com.wish.sys.form.PermissionForm;
import com.wish.sys.service.SysPermissionService;
import com.wish.sys.validate.PermissionValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "权限管理")
@RestController
@RequestMapping("/sys/permission")
public class SysPermissionController extends AbstractController {

    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private PermissionValidator permissionValidator;

    @ApiOperation("权限保存")
    @PostMapping("/save")
    public R save(@RequestBody PermissionForm form) {
        Permission permission = permissionValidator.validate(form);
        sysPermissionService.save(permission);
        return R.ok();
    }

    @ApiOperation("权限修改")
    @PostMapping("/update")
    public R update(@RequestBody PermissionForm form) {
        if(form.getPermissionId() == null) {
            throw new RRException("id不能为空");
        }
        Permission permission = permissionValidator.validate(form);
        sysPermissionService.updateById(permission);
        return R.ok();
    }

    @ApiOperation("权限删除")
    @PostMapping("/delete/{permissionId}")
    public R delete(@PathVariable("permissionId") Integer permissionId) {
        sysPermissionService.delete(permissionId);
        return R.ok();
    }

    @ApiOperation("权限详情")
    @PostMapping("/info/{permissionId}")
    public R info(@PathVariable("permissionId") long permissionId) {
        Permission permission = sysPermissionService.getById(permissionId);
        return R.ok().put("permission",permission);
    }

    @ApiOperation("权限列表")
    @PostMapping("/list")
    public List<Permission> list() {
        return sysPermissionService.list();
    }

}














