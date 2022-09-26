package com.cj.core.auto.dto;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * <p>
 * 用户信息 DTO类
 * </p>
 *
 * @author lang.chaojin
 * @since 2022-09-15
 */
@Data
@ApiModel(value="CjUser对象", description="用户信息")
public class CjUserDTO implements Serializable{
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
    private Date  pwdExpireDate;
    @ApiModelProperty(value = "最后密码修改时间")
    private Date  lastPwdUpdateDate;
    @ApiModelProperty(value = "最后登录时间")
    private Date  lastLoginDate;
    @ApiModelProperty(value = "最后登录ip")
    private String  lastLoginIp;
    @ApiModelProperty(value = "机构id")
    private Long  orgId;
    @ApiModelProperty(value = "创建者")
    private Long  createBy;
    @ApiModelProperty(value = "创建时间")
    private Date  createDate;
    @ApiModelProperty(value = "更新者")
    private Long  updateBy;
    @ApiModelProperty(value = "更新时间")
    private Date  updateDate;
    @ApiModelProperty(value = "删除标记0:保留,1:删除")
    private Integer  delFlag;
    @ApiModelProperty(value = "当前第几页")
    private int currentpage;
    @ApiModelProperty(value = "每页数据条数")
    private int pagesize;
}
