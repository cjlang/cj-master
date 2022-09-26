package com.cj.core.auto.service;

import com.cj.core.auto.entity.CjRoleEntity;
import com.cj.core.auto.dto.CjRoleDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * 用户角色 接口服务类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
@Primary
public interface ICjRoleService_ extends IService<CjRoleEntity> {
  public List<CjRoleEntity> getList(CjRoleDTO dto);
  public IPage<CjRoleEntity> getPageList(CjRoleDTO dto);
}
