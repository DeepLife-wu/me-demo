package com.wish.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Permission {
    @TableId(type = IdType.AUTO)
    private Integer permissionId;

    private String name;

    private String type;

    private String action;

}