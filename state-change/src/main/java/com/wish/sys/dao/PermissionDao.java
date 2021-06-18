package com.wish.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wish.sys.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionDao extends BaseMapper<Permission> {
    int deleteByPrimaryKey(Integer permissionId);

//    int insert(Permission record);

//    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}