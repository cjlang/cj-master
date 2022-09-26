package com.cj.core.auto.service;

import com.cj.core.auto.entity.CjUserConfigEntity;
import com.cj.core.auto.dto.CjUserConfigDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * 用户个性化配置 接口服务类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
@Primary
public interface ICjUserConfigService_ extends IService<CjUserConfigEntity> {
  public List<CjUserConfigEntity> getList(CjUserConfigDTO dto);
  public IPage<CjUserConfigEntity> getPageList(CjUserConfigDTO dto);
}
