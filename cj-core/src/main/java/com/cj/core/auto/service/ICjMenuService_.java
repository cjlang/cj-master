package com.cj.core.auto.service;

import com.cj.core.auto.entity.CjMenuEntity;
import com.cj.core.auto.dto.CjMenuDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * 系统菜单 接口服务类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
@Primary
public interface ICjMenuService_ extends IService<CjMenuEntity> {
  public List<CjMenuEntity> getList(CjMenuDTO dto);
  public IPage<CjMenuEntity> getPageList(CjMenuDTO dto);
}
