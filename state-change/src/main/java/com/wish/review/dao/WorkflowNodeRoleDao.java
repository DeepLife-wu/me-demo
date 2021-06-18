package com.wish.review.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wish.review.entity.WorkflowNodeRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkflowNodeRoleDao /*extends BaseMapper<WorkflowNodeRole> */{
    int insert(WorkflowNodeRole record);

    int insertSelective(WorkflowNodeRole record);

    List<WorkflowNodeRole> queryAll(WorkflowNodeRole nodeRole);
}