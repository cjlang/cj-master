package com.cj.core.auto.service;

import com.cj.core.auto.entity.CjDictEntity;
import com.cj.core.auto.dto.CjDictDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * 数据字典 接口服务类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
@Primary
public interface ICjDictService_ extends IService<CjDictEntity> {
  public List<CjDictEntity> getList(CjDictDTO dto);
  public IPage<CjDictEntity> getPageList(CjDictDTO dto);
}
