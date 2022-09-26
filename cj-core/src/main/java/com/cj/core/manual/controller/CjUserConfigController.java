package com.cj.core.manual.controller;

import com.cj.common.vo.J;
import com.cj.core.auto.bllservice.CjUserConfigBllService_;
import com.cj.core.auto.dto.CjUserConfigDTO;
import com.cj.core.auto.vo.CjUserConfigVo;
import com.cj.core.manual.bllservice.CjConfigService;
import com.cj.core.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
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
@Api(value = "用户配置管理", tags = {"[用户配置接口]"})
@RequestMapping("/userconfig")
public class CjUserConfigController {
  
  @Autowired
  CjUserConfigBllService_ cjUserConfigBllService_;

  @Autowired
  CjConfigService cjConfigService;

  @PostMapping("/sync")
  @ApiOperation(value = "同步配置", notes = "")
  public J updateUserConfig(@ApiParam(value = "传入json格式", required = true) @RequestBody CjUserConfigDTO dto) throws Exception {
    CjUserConfigDTO temp=new CjUserConfigDTO();
    temp.setGroupName(dto.getGroupName());
    temp.setConfigName(dto.getConfigName());
    temp.setUsername(TokenUtils.getUserName());
    System.out.println("----------------------->TokenUtils.getUserName()="+TokenUtils.getUserName());
    List<CjUserConfigVo> list=cjConfigService.getUserConfigList(temp);
    if(list.size()>0){
      temp.setId(list.get(0).getId());
      temp.setConfigValue(dto.getConfigValue());
      cjUserConfigBllService_.update(temp);
    }else{
      dto.setUsername(TokenUtils.getUserName());
      cjUserConfigBllService_.add(dto);
    }
    return J.ok();
  }
  @PostMapping("/list")
  @ApiOperation(value = "获取User配置的列表", notes = "")
  public J getUserConfig(@ApiParam(value = "传入json格式", required = true) @RequestBody CjUserConfigDTO dto) throws Exception {
    return J.ok().put(cjConfigService.getUserConfigList(dto));
  }
}


