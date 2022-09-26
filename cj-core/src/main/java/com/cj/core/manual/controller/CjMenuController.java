package com.cj.core.manual.controller;

import com.cj.common.vo.J;
import com.cj.core.auto.dto.CjMenuDTO;
import com.cj.core.manual.bllservice.CjMenuBllService;
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
* @since 2022-09-04
*/
@RestController
@Api(value = "菜单信息表管理", tags = {"[菜单信息表接口]"})
@RequestMapping("/cjmenu")
public class CjMenuController {
  
  @Autowired
  CjMenuBllService cjMenuBllService;

  @PostMapping("/treelist")
  @ApiOperation(value = "获取菜单数", notes = "")
  public J getList(@ApiParam(value = "传入json格式", required = true) @RequestBody CjMenuDTO dto){
    return J.ok().put(cjMenuBllService.getMenuTree(dto));
  }
}


