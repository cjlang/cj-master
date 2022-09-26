package com.cj.core.manual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单信息表 VO类
 * </p>
 *
 * @author lang.chaojin
 * @since 2022-09-04
 */
@Data
@ApiModel(value="CjMenu树对象", description="菜单信息表")
public class MenuNode {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private  String  id;
    @ApiModelProperty(value = "类型：1目录，2菜单，3权限,4，系统菜单")
    private Integer  type;
    @ApiModelProperty(value = "菜单编码，权限标识,menuCode")
    private String  menuCode;
    @ApiModelProperty(value = "父ID")
    private Long  pid;
    @ApiModelProperty(value = "菜单层级")
    private Integer  level;
    @ApiModelProperty(value = "菜单名称，权限名称，目录名称,menuName")
    private String  menuName;
    @ApiModelProperty(value = "菜单路径")
    private String  urlPath;
    @ApiModelProperty(value = "组件路径")
    private String  component;
    @ApiModelProperty(value = "是否外链接：0否1是")
    private Integer  iframe;
    @ApiModelProperty(value = "外链接路径")
    private String  iframePath;
    @ApiModelProperty(value = "图标")
    private String  icon;
    @ApiModelProperty(value = "X位置")
    private String  layerX;
    @ApiModelProperty(value = "Y位置")
    private String  layerY;
    @ApiModelProperty(value = "窗口宽度")
    private String  width;
    @ApiModelProperty(value = "窗口高度")
    private String  height;
    @ApiModelProperty(value = "最小宽度")
    private String  minWidth;
    @ApiModelProperty(value = "最小高度")
    private String  minHeight;
    @ApiModelProperty(value = "是否系统窗口：0否1是")
    private Integer  sysWindow;
    @ApiModelProperty(value = "图标颜色")
    private String  iconColor;
    @ApiModelProperty(value = "图片还是图标：image 或者 icon")
    private String  imgOrIcon;
    @ApiModelProperty(value = "图片路径")
    private String  imgUrl;
    @ApiModelProperty(value = "横跨列")
    private Integer  span;
    @ApiModelProperty(value = "菜单排序")
    private Integer  orderNum;
    @ApiModelProperty(value = "备注")
    private String  remark;
    @ApiModelProperty(value = "创建时间")
    private Date  createDate;
    @ApiModelProperty(value = "创建者")
    private Long  createBy;
    @ApiModelProperty(value = "更新者")
    private Long  updateBy;
    @ApiModelProperty(value = "更新时间")
    private Date  updateDate;
    @ApiModelProperty(value = "删除标记0:保留,1:删除")
    private Integer  delFlag;

    private List<MenuNode> children;
}
