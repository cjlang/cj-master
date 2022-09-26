package com.cj.core.auto.vo;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * <p>
 * 用户个性化配置 VO类
 * </p>
 *
 * @author lang.chaojin
 * @since 2022-09-15
 */
@Data
@ApiModel(value="CjUserConfig对象", description="用户个性化配置")
public class CjUserConfigVo{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private  String  id;
    @ApiModelProperty(value = "用户")
    private String  username;
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
}
