package com.cj.core.auto.dto;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * <p>
 * 数据字典-子项 DTO类
 * </p>
 *
 * @author lang.chaojin
 * @since 2022-09-15
 */
@Data
@ApiModel(value="CjDictItem对象", description="数据字典-子项")
public class CjDictItemDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private  String  id;
    @ApiModelProperty(value = "字典类型ID")
    private Long  typeId;
    @ApiModelProperty(value = "字典编码")
    private String  code;
    @ApiModelProperty(value = "字典名称")
    private String  name;
    @ApiModelProperty(value = "排序")
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
    @ApiModelProperty(value = "当前第几页")
    private int currentpage;
    @ApiModelProperty(value = "每页数据条数")
    private int pagesize;
}
