package com.cj.core.auto.service;

import com.cj.core.auto.entity.CjUserEntity;
import com.cj.core.auto.dto.CjUserDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * 用户信息 接口服务类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
@Primary
public interface ICjUserService_ extends IService<CjUserEntity> {
  public List<CjUserEntity> getList(CjUserDTO dto);
  public IPage<CjUserEntity> getPageList(CjUserDTO dto);
}
