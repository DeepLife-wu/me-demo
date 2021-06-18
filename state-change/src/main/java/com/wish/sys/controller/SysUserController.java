package com.wish.sys.controller;

import com.google.common.collect.Lists;
import com.wish.common.utils.PageUtils;
import com.wish.common.utils.R;
import com.wish.common.validator.ValidatorUtils;
import com.wish.common.validator.group.AddGroup;
import com.wish.common.validator.group.UpdateGroup;
import com.wish.sys.dao.RoleDao;
import com.wish.sys.dao.UserRoleDao;
import com.wish.sys.entity.Role;
import com.wish.sys.entity.User;
import com.wish.sys.entity.UserRoleKey;
import com.wish.sys.form.UserForm;
import com.wish.sys.form.UserResponse;
import com.wish.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
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

@Api(tags = "用户管理")
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleDao roleDao;

    @ApiOperation("用户列表")
    @PostMapping("/list")
    public R list(@RequestParam(required = false) Map<String,Object> params) {
        PageUtils page = sysUserService.queryPage(params);
        return R.ok().put("page", page);
    }

    @ApiOperation("用户信息")
    @GetMapping("/info/{userId}")
    public R info(@PathVariable("userId") Integer userId){
        User user = sysUserService.getById(userId);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user,userResponse);

        //获取用户所属的角色列表
        UserRoleKey userRoleKey = new UserRoleKey();
        userRoleKey.setUserId(userId);
        List<UserRoleKey> userRoleKeys = userRoleDao.selectBy(userRoleKey);
        if(CollectionUtils.isNotEmpty(userRoleKeys)) {
            List<Role> roleList = Lists.newArrayList();
            for (UserRoleKey userRole : userRoleKeys) {
                Role role = roleDao.selectByPrimaryKey(userRole.getRoleId());
                roleList.add(role);
            }
            userResponse.setRoleList(roleList);
        }
        return R.ok().put("user", userResponse);
    }

    @ApiOperation("保存用户")
    @PostMapping("/save")
    public R save(@RequestBody UserForm form){
        ValidatorUtils.validateEntity(form, AddGroup.class);
        sysUserService.saveUser(form);
        return R.ok();
    }

    @ApiOperation("修改用户")
    @PostMapping("/update")
    public R update(@RequestBody UserForm form){
        ValidatorUtils.validateEntity(form, UpdateGroup.class);
        sysUserService.updateUser(form);
        return R.ok();
    }

    @ApiOperation("删除用户")
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] userIds){
        if(ArrayUtils.contains(userIds, 1L)){
            return R.error("系统管理员不能删除");
        }
        sysUserService.deleteBatch(userIds);
        return R.ok();
    }

}
