package com.cj.core.auto.vo;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * <p>
 * 用户角色关系 VO类
 * </p>
 *
 * @author lang.chaojin
 * @since 2022-09-15
 */
@Data
@ApiModel(value="CjUserRole对象", description="用户角色关系")
public class CjUserRoleVo{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private  String  id;
    @ApiModelProperty(value = "用户id")
    private Long  userId;
    @ApiModelProperty(value = "角色id")
    private Long  roleId;
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
}
