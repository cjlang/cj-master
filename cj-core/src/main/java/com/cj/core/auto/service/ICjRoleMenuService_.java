package com.cj.core.auto.service;

import com.cj.core.auto.entity.CjRoleMenuEntity;
import com.cj.core.auto.dto.CjRoleMenuDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * 角色菜单关系 接口服务类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
@Primary
public interface ICjRoleMenuService_ extends IService<CjRoleMenuEntity> {
  public List<CjRoleMenuEntity> getList(CjRoleMenuDTO dto);
  public IPage<CjRoleMenuEntity> getPageList(CjRoleMenuDTO dto);
}
