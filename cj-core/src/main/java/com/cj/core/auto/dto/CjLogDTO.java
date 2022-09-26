package com.cj.core.auto.dto;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * <p>
 * 业务日志 DTO类
 * </p>
 *
 * @author lang.chaojin
 * @since 2022-09-15
 */
@Data
@ApiModel(value="CjLog对象", description="业务日志")
public class CjLogDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private  String  id;
    @ApiModelProperty(value = "模块名")
    private String  bllModule;
    @ApiModelProperty(value = "会话ID")
    private String  sessionId;
    @ApiModelProperty(value = "线程ID")
    private String  threadId;
    @ApiModelProperty(value = "类信息")
    private String  calssInfo;
    @ApiModelProperty(value = "日志内容")
    private String  content;
    @ApiModelProperty(value = "精确到毫秒")
    private String  logTime;
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
