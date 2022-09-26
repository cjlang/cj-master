package com.cj.core.auto.entity;
import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;

/**
* <p>
    * 用户信息 实体类
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("cj_user")
    @ApiModel(value="CjUser对象", description="用户信息")
    public class CjUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private  String  id;

    @ApiModelProperty(value = "账号")
    @TableField("username")
    private String  username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String  password;

    @ApiModelProperty(value = "真实姓名")
    @TableField("real_name")
    private String  realName;

    @ApiModelProperty(value = "状态 1:正常，0:禁用")
    @TableField("status")
    private Integer  status;

    @ApiModelProperty(value = "密码过期时间")
    @TableField("pwd_expire_date")
    private Date  pwdExpireDate;

    @ApiModelProperty(value = "最后密码修改时间")
    @TableField("last_pwd_update_date")
    private Date  lastPwdUpdateDate;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("last_login_date")
    private Date  lastLoginDate;

    @ApiModelProperty(value = "最后登录ip")
    @TableField("last_login_ip")
    private String  lastLoginIp;

    @ApiModelProperty(value = "机构id")
    @TableField(value = "org_id", fill = FieldFill.INSERT)
    private Long  orgId;

    @ApiModelProperty(value = "创建者")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long  createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date  createDate;

    @ApiModelProperty(value = "更新者")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private Long  updateBy;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    private Date  updateDate;

    @ApiModelProperty(value = "删除标记0:保留,1:删除")
    @TableField("del_flag")
    private Integer  delFlag;


}
