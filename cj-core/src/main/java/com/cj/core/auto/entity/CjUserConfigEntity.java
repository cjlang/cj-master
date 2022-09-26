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
    * 用户个性化配置 实体类
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("cj_user_config")
    @ApiModel(value="CjUserConfig对象", description="用户个性化配置")
    public class CjUserConfigEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private  String  id;

    @ApiModelProperty(value = "用户")
    @TableField("username")
    private String  username;

    @ApiModelProperty(value = "配置组")
    @TableField("group_name")
    private String  groupName;

    @ApiModelProperty(value = "配置项名称")
    @TableField("config_name")
    private String  configName;

    @ApiModelProperty(value = "配置值")
    @TableField("config_value")
    private String  configValue;

    @ApiModelProperty(value = "是否启用")
    @TableField("active")
    private Integer  active;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date  createDate;

    @ApiModelProperty(value = "创建者")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long  createBy;

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
