package com.cj.core.auto.service;

import com.cj.core.auto.entity.CjDictItemEntity;
import com.cj.core.auto.dto.CjDictItemDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * 数据字典-子项 接口服务类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
@Primary
public interface ICjDictItemService_ extends IService<CjDictItemEntity> {
  public List<CjDictItemEntity> getList(CjDictItemDTO dto);
  public IPage<CjDictItemEntity> getPageList(CjDictItemDTO dto);
}
