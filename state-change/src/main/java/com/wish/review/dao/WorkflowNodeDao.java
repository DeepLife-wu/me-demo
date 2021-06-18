package com.wish.review.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wish.review.entity.WorkflowNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkflowNodeDao /*extends BaseMapper<WorkflowNode>*/ {
    int deleteByPrimaryKey(Integer nodeId);

    int insert(WorkflowNode record);

    int insertSelective(WorkflowNode record);

    WorkflowNode selectByPrimaryKey(Integer nodeId);

    int updateByPrimaryKeySelective(WorkflowNode record);

    int updateByPrimaryKey(WorkflowNode record);

    List<WorkflowNode> queryAll();
}