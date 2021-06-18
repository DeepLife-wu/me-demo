package com.wish.sys.form;

import com.wish.sys.entity.Permission;
import lombok.Data;

import java.util.List;

@Data
public class RoleResponse {

    private Integer roleId;

    private String name;

    private String description;

    private List<Permission> permissionList;

}
