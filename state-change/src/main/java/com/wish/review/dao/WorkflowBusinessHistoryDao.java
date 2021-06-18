package com.wish.review.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wish.review.entity.WorkflowBusinessHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkflowBusinessHistoryDao /*extends BaseMapper<WorkflowBusinessHistory>*/ {
    int deleteByPrimaryKey(Integer historyId);

    int insert(WorkflowBusinessHistory record);

    int insertSelective(WorkflowBusinessHistory record);

    WorkflowBusinessHistory selectByPrimaryKey(Integer historyId);

    int updateByPrimaryKeySelective(WorkflowBusinessHistory record);

    int updateByPrimaryKeyWithBLOBs(WorkflowBusinessHistory record);

    int updateByPrimaryKey(WorkflowBusinessHistory record);
}