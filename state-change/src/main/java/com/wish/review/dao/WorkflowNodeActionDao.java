package com.wish.review.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wish.review.entity.WorkflowNodeAction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkflowNodeActionDao /*extends BaseMapper<WorkflowNodeAction>*/ {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkflowNodeAction record);

    int insertSelective(WorkflowNodeAction record);

    WorkflowNodeAction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkflowNodeAction record);

    int updateByPrimaryKey(WorkflowNodeAction record);
}