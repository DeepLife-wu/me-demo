package com.wish.sys.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class RoleForm {

    private Integer roleId;

    @NotBlank(message="角色名称不能为空")
    private String name;

    private String description;

    private List<Integer> permissionList;

}
