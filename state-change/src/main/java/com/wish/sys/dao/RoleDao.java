package com.wish.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wish.sys.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao extends BaseMapper<Role> {
    int deleteByPrimaryKey(Integer roleId);

//    int insert(Role record);

//    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> queryAll(Role role);
}