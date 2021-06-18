package com.wish.sys.form;

import com.wish.sys.entity.Role;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserResponse {
    private Integer userId;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private Date birthday;

    private List<Role> roleList;
}
