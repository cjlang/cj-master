package ${package.Controller};

import ${package.Entity?replace('entity','')}bllservice.${entity}BllService_;
import ${package.Entity?replace('entity','dto')}.${entity}DTO;
import com.cj.common.vo.J;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
* <p>
  *  前端控制器
  * </p>
*
* @author ${author}
* @since ${date}
*/
@RestController
@Api(value = "${table.comment!}管理", tags = {"[${table.comment!}接口]"})
@RequestMapping("/${entity?lower_case}")
public class ${entity}Controller_ {
  
  @Autowired
  ${entity}BllService_ ${entity?uncap_first}BllService_;
  
  @PostMapping("/add")
  @ApiOperation(value = "增加", notes = "")
  public J add(@ApiParam(value = "传入json格式", required = true) @RequestBody ${entity}DTO dto) throws Exception {
    return ${entity?uncap_first}BllService_.add(dto)?J.ok():J.error();
  }
  
  @PostMapping("/del")
  @ApiOperation(value = "删除", notes = "")
  public J del(@ApiParam(value = "传入json格式", required = true) @RequestBody ${entity}DTO dto) throws Exception {
    return ${entity?uncap_first}BllService_.del(dto.getId())?J.ok():J.error();
  }
  
  @PostMapping("/update")
  @ApiOperation(value = "修改", notes = "传什么修改什么，不传的不变")
  public J update(@ApiParam(value = "传入json格式", required = true) @RequestBody ${entity}DTO dto) throws Exception {
    return ${entity?uncap_first}BllService_.update(dto)?J.ok():J.error();
  }

  @PostMapping("/list")
  @ApiOperation(value = "7、查询，不分页", notes = "")
  public J getList(@ApiParam(value = "传入json格式", required = true) @RequestBody ${entity}DTO dto) throws Exception {
    return J.ok().put(${entity?uncap_first}BllService_.getList(dto));
  }

  @PostMapping("/pagelist")
  @ApiOperation(value = "8、查询，分页", notes = "dto需要传入pagesize和currentpage")
  public J getPageList(@ApiParam(value = "传入json格式", required = true) @RequestBody ${entity}DTO dto) throws Exception {
    return J.ok().put(${entity?uncap_first}BllService_.getPageList(dto));
  }
}


