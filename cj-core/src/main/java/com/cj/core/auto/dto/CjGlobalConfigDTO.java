package com.cj.core.auto.dto;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * <p>
 * 系统全局配置 DTO类
 * </p>
 *
 * @author lang.chaojin
 * @since 2022-09-15
 */
@Data
@ApiModel(value="CjGlobalConfig对象", description="系统全局配置")
public class CjGlobalConfigDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private  String  id;
    @ApiModelProperty(value = "配置组")
    private String  groupName;
    @ApiModelProperty(value = "配置项名称")
    private String  configName;
    @ApiModelProperty(value = "配置值")
    private String  configValue;
    @ApiModelProperty(value = "是否启用")
    private Integer  active;
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
