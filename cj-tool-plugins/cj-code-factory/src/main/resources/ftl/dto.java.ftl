package ${package.Entity?replace('entity','dto')};
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * <p>
 * ${table.comment!} DTO类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Data
<#if swagger2>
@ApiModel(value="${entity}对象", description="${table.comment!}")
</#if>
public class ${entity}DTO implements Serializable{
<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.comment!?length gt 0>
        <#if swagger2>
    @ApiModelProperty(value = "${field.comment}")
        <#else>
    /**
     * ${field.comment}
     */
        </#if>
    </#if>
    private <#if 'id' == field.name> String <#elseif 'del_flag' == field.name>Integer <#elseif 'LocalDateTime' == field.propertyType>Date <#else>${field.propertyType} </#if> ${field.propertyName};
</#list>
    @ApiModelProperty(value = "当前第几页")
    private int currentpage;
    @ApiModelProperty(value = "每页数据条数")
    private int pagesize;
}
