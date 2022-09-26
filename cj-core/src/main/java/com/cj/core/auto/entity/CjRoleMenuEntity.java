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
    * 角色菜单关系 实体类
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("cj_role_menu")
    @ApiModel(value="CjRoleMenu对象", description="角色菜单关系")
    public class CjRoleMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private  String  id;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Long  roleId;

    @ApiModelProperty(value = "菜单id")
    @TableField("menu_id")
    private Long  menuId;

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
