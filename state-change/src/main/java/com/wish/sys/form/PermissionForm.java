package com.wish.sys.form;

import lombok.Data;

@Data
public class PermissionForm {
    private Integer permissionId;

    private String name;

    private String type;

    private String action;
}
