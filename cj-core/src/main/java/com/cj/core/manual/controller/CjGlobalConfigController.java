package com.cj.core.manual.controller;

import com.cj.common.vo.J;
import com.cj.core.auto.bllservice.CjGlobalConfigBllService_;
import com.cj.core.auto.dto.CjGlobalConfigDTO;
import com.cj.core.auto.vo.CjGlobalConfigVo;
import com.cj.core.manual.bllservice.CjConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* <p>
  *  前端控制器
  * </p>
*
* @author lang.chaojin
* @since 2022-09-13
*/
@RestController
@Api(value = "全局配置管理", tags = {"[全局配置接口]"})
@RequestMapping("/globalconfig")
public class CjGlobalConfigController {
  
  @Autowired
  CjGlobalConfigBllService_ cjGlobalConfigBllService_;
  @Autowired
  CjConfigService cjConfigService;

  @PostMapping("/sync")
  @ApiOperation(value = "同步配置", notes = "")
  public J updateGlobalConfig(@ApiParam(value = "传入json格式", required = true) @RequestBody CjGlobalConfigDTO dto) throws Exception {
    CjGlobalConfigDTO temp=new CjGlobalConfigDTO();
    temp.setGroupName(dto.getGroupName());
    temp.setConfigName(dto.getConfigName());
    List<CjGlobalConfigVo> list=cjConfigService.getGlobalConfigList(temp);
    if(list.size()>0){
      temp.setId(list.get(0).getId());
      temp.setConfigValue(dto.getConfigValue());
      cjGlobalConfigBllService_.update(temp);
    }else{
      cjGlobalConfigBllService_.add(dto);
    }
    return J.ok();
  }

  @PostMapping("/list")
  @ApiOperation(value = "获取gobal配置列表", notes = "")
  public J getGlobalConfig(@ApiParam(value = "传入json格式", required = true) @RequestBody CjGlobalConfigDTO dto) throws Exception {
    return J.ok().put(cjConfigService.getGlobalConfigList(dto));
  }


}


