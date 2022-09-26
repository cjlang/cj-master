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
    * 系统菜单 实体类
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("cj_menu")
    @ApiModel(value="CjMenu对象", description="系统菜单")
    public class CjMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private  String  id;

    @ApiModelProperty(value = "类型：1目录，2菜单，3权限,4，系统菜单")
    @TableField("type")
    private Integer  type;

    @ApiModelProperty(value = "菜单编码，权限标识,menuCode")
    @TableField("menu_code")
    private String  menuCode;

    @ApiModelProperty(value = "父ID")
    @TableField("pid")
    private Long  pid;

    @ApiModelProperty(value = "菜单层级")
    @TableField("level")
    private Integer  level;

    @ApiModelProperty(value = "菜单名称，权限名称，目录名称,menuName")
    @TableField("menu_name")
    private String  menuName;

    @ApiModelProperty(value = "菜单路径")
    @TableField("url_path")
    private String  urlPath;

    @ApiModelProperty(value = "组件路径")
    @TableField("component")
    private String  component;

    @ApiModelProperty(value = "是否外链接：0否1是")
    @TableField("iframe")
    private Integer  iframe;

    @ApiModelProperty(value = "外链接路径")
    @TableField("iframe_path")
    private String  iframePath;

    @ApiModelProperty(value = "图标")
    @TableField("icon")
    private String  icon;

    @ApiModelProperty(value = "X位置")
    @TableField("layer_x")
    private String  layerX;

    @ApiModelProperty(value = "Y位置")
    @TableField("layer_y")
    private String  layerY;

    @ApiModelProperty(value = "窗口宽度")
    @TableField("width")
    private String  width;

    @ApiModelProperty(value = "窗口高度")
    @TableField("height")
    private String  height;

    @ApiModelProperty(value = "最小宽度")
    @TableField("min_width")
    private String  minWidth;

    @ApiModelProperty(value = "最小高度")
    @TableField("min_height")
    private String  minHeight;

    @ApiModelProperty(value = "是否系统窗口：0否1是")
    @TableField("sys_window")
    private Integer  sysWindow;

    @ApiModelProperty(value = "图标颜色")
    @TableField("icon_color")
    private String  iconColor;

    @ApiModelProperty(value = "图片还是图标：image 或者 icon")
    @TableField("img_or_icon")
    private String  imgOrIcon;

    @ApiModelProperty(value = "图片路径")
    @TableField("img_url")
    private String  imgUrl;

    @ApiModelProperty(value = "横跨列")
    @TableField("span")
    private Integer  span;

    @ApiModelProperty(value = "菜单排序")
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
