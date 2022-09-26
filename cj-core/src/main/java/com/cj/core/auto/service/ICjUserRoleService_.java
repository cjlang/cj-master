package com.cj.core.auto.service;

import com.cj.core.auto.entity.CjUserRoleEntity;
import com.cj.core.auto.dto.CjUserRoleDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * 用户角色关系 接口服务类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
@Primary
public interface ICjUserRoleService_ extends IService<CjUserRoleEntity> {
  public List<CjUserRoleEntity> getList(CjUserRoleDTO dto);
  public IPage<CjUserRoleEntity> getPageList(CjUserRoleDTO dto);
}
