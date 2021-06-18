package com.wish.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private Date birthday;

}