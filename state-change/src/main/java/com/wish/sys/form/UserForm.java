package com.wish.sys.form;

import com.wish.common.validator.group.AddGroup;
import com.wish.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
public class UserForm {
    private Integer userId;

    @NotBlank(message="用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String username;

    @NotBlank(message="密码不能为空", groups = AddGroup.class)
    private String password;

    @NotBlank(message="手机号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Pattern(regexp = "^\\d{11}",message = "手机号格式不正确",groups = {AddGroup.class, UpdateGroup.class})
    private String mobile;

    @NotBlank(message="邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    private Date birthday;

    private List<Integer> roleIdList;
}
