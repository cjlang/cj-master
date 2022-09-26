package com.cj.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
public class UserInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private  String  id;
    @ApiModelProperty(value = "账号")
    private String  username;
    @ApiModelProperty(value = "密码")
    private String  password;
    @ApiModelProperty(value = "真实姓名")
    private String  realName;
    @ApiModelProperty(value = "状态 1:正常，0:禁用")
    private Integer  status;
    @ApiModelProperty(value = "密码过期时间")
    private Date pwdExpireDate;
    @ApiModelProperty(value = "最后密码修改时间")
    private Date  lastPwdUpdateDate;
    @ApiModelProperty(value = "最后登录时间")
    private Date  lastLoginDate;
    @ApiModelProperty(value = "最后登录ip")
    private String  lastLoginIp;
    @ApiModelProperty(value = "机构id")
    private Long  orgId;

    @ApiModelProperty(value = "角色列表")
    private Set<String> roles;

    @ApiModelProperty(value = "权限列表")
    private Set<String> perms;

}
