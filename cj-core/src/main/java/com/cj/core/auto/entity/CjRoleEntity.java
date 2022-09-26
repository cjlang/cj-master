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
    * 用户角色 实体类
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("cj_role")
    @ApiModel(value="CjRole对象", description="用户角色")
    public class CjRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private  String  id;

    @ApiModelProperty(value = "角色编码")
    @TableField("code")
    private String  code;

    @ApiModelProperty(value = "角色名称")
    @TableField("name")
    private String  name;

    @ApiModelProperty(value = "类型1:系统角色2:业务角色3:机构角色")
    @TableField("type")
    private String  type;

    @ApiModelProperty(value = "角色排序")
    @TableField("order_num")
    private Integer  orderNum;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String  remark;

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
