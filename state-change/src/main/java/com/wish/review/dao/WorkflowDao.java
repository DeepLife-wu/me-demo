package com.wish.review.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wish.review.entity.Workflow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkflowDao /*extends BaseMapper<Workflow> */{
    int deleteByPrimaryKey(Integer workflowId);

    int insert(Workflow record);

    int insertSelective(Workflow record);

    Workflow selectByPrimaryKey(Integer workflowId);

    int updateByPrimaryKeySelective(Workflow record);

    int updateByPrimaryKey(Workflow record);
}