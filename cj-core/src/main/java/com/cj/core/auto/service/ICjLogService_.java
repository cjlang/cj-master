package com.cj.core.auto.service;

import com.cj.core.auto.entity.CjLogEntity;
import com.cj.core.auto.dto.CjLogDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * 业务日志 接口服务类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
@Primary
public interface ICjLogService_ extends IService<CjLogEntity> {
  public List<CjLogEntity> getList(CjLogDTO dto);
  public IPage<CjLogEntity> getPageList(CjLogDTO dto);
}
