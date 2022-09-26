package com.cj.core.auto.controller;

import com.cj.core.auto.bllservice.CjUserRoleBllService_;
import com.cj.core.auto.dto.CjUserRoleDTO;
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
* @author lang.chaojin
* @since 2022-09-15
*/
@RestController
@Api(value = "用户角色关系管理", tags = {"[用户角色关系接口]"})
@RequestMapping("/cjuserrole")
public class CjUserRoleController_ {
  
  @Autowired
  CjUserRoleBllService_ cjUserRoleBllService_;
  
  @PostMapping("/add")
  @ApiOperation(value = "增加", notes = "")
  public J add(@ApiParam(value = "传入json格式", required = true) @RequestBody CjUserRoleDTO dto) throws Exception {
    return cjUserRoleBllService_.add(dto)?J.ok():J.error();
  }
  
  @PostMapping("/del")
  @ApiOperation(value = "删除", notes = "")
  public J del(@ApiParam(value = "传入json格式", required = true) @RequestBody CjUserRoleDTO dto) throws Exception {
    return cjUserRoleBllService_.del(dto.getId())?J.ok():J.error();
  }
  
  @PostMapping("/update")
  @ApiOperation(value = "修改", notes = "传什么修改什么，不传的不变")
  public J update(@ApiParam(value = "传入json格式", required = true) @RequestBody CjUserRoleDTO dto) throws Exception {
    return cjUserRoleBllService_.update(dto)?J.ok():J.error();
  }

  @PostMapping("/list")
  @ApiOperation(value = "7、查询，不分页", notes = "")
  public J getList(@ApiParam(value = "传入json格式", required = true) @RequestBody CjUserRoleDTO dto) throws Exception {
    return J.ok().put(cjUserRoleBllService_.getList(dto));
  }

  @PostMapping("/pagelist")
  @ApiOperation(value = "8、查询，分页", notes = "dto需要传入pagesize和currentpage")
  public J getPageList(@ApiParam(value = "传入json格式", required = true) @RequestBody CjUserRoleDTO dto) throws Exception {
    return J.ok().put(cjUserRoleBllService_.getPageList(dto));
  }
}


