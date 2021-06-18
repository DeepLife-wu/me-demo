package com.wish.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wish.common.utils.PageUtils;
import com.wish.common.utils.Query;
import com.wish.sys.dao.UserDao;
import com.wish.sys.dao.UserRoleDao;
import com.wish.sys.entity.User;
import com.wish.sys.entity.UserRoleKey;
import com.wish.sys.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SysUserService extends ServiceImpl<UserDao, User> {

    @Autowired
    private UserRoleDao userRoleDao;

    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String)params.get("username");

        IPage<User> page = this.page(
                new Query<User>().getPage(params),
                new QueryWrapper<User>()
                        .like(StringUtils.isNotBlank(username),"username", username)
        );

        return new PageUtils(page);
    }

    public void saveUser(UserForm form) {
        User user = new User();
        BeanUtils.copyProperties(form,user);
        this.save(user);

        form.setUserId(user.getUserId());
        assignRole(form);
    }

    private void assignRole(UserForm form) {
        List<Integer> roleIdList = form.getRoleIdList();
        if(CollectionUtils.isNotEmpty(roleIdList)) {
            UserRoleKey key = new UserRoleKey();
            key.setUserId(form.getUserId());
            userRoleDao.deleteByPrimaryKey(key);

            for(Integer roleId : roleIdList) {
                UserRoleKey userRoleKey = new UserRoleKey();
                userRoleKey.setUserId(form.getUserId());
                userRoleKey.setRoleId(roleId);
                userRoleDao.insert(userRoleKey);
            }
        }
    }

    public void updateUser(UserForm form) {
        User user = new User();
        BeanUtils.copyProperties(form,user);
        this.updateById(user);
        assignRole(form);
    }

    public void deleteBatch(Integer[] userIds) {
        this.removeByIds(Arrays.asList(userIds));
        removeUserRole(userIds);
    }

    private void removeUserRole(Integer[] userIds) {
        if(userIds != null && userIds.length > 0) {
            for(Integer userId : userIds) {
                UserRoleKey key = new UserRoleKey();
                key.setUserId(userId);
                userRoleDao.deleteByPrimaryKey(key);
            }
        }
    }
}
