package com.wish.review.dao;


import com.wish.review.entity.WorkflowBusiness;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkflowBusinessDao /*extends BaseMapper<WorkflowBusiness>*/ {
    int deleteByPrimaryKey(Integer workflowBusinessId);

    int insert(WorkflowBusiness record);

    int insertSelective(WorkflowBusiness record);

    WorkflowBusiness selectByPrimaryKey(Integer workflowBusinessId);

    int updateByPrimaryKeySelective(WorkflowBusiness record);

    int updateByPrimaryKey(WorkflowBusiness record);

    WorkflowBusiness lockByPrimaryKey(Integer workflowBusinessId);

}