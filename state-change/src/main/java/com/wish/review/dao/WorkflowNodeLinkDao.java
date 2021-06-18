package com.wish.review.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wish.review.dto.ActionDto;
import com.wish.review.entity.WorkflowNodeLink;
import com.wish.review.entity.WorkflowNodeLinkKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkflowNodeLinkDao /*extends BaseMapper<WorkflowNodeLink> */{
    int deleteByPrimaryKey(WorkflowNodeLinkKey key);

    int insert(WorkflowNodeLink record);

    int insertSelective(WorkflowNodeLink record);

    WorkflowNodeLink selectByPrimaryKey(WorkflowNodeLinkKey key);

    int updateByPrimaryKeySelective(WorkflowNodeLink record);

    int updateByPrimaryKey(WorkflowNodeLink record);

    WorkflowNodeLink queryNodeLink(ActionDto actionDto);
}