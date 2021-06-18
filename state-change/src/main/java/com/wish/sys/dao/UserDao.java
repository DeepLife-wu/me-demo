package com.wish.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wish.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User>  {
    int deleteByPrimaryKey(Integer userId);

//    int insert(User record);

//    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}