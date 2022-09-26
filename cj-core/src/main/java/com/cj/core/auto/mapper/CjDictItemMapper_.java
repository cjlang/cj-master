package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjDictItemDTO;
import com.cj.core.auto.vo.CjDictItemVo;
import com.cj.core.auto.entity.CjDictItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 数据字典-子项 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjDictItemMapper_ extends BaseMapper<CjDictItemEntity> {

    List<CjDictItemVo> getList(@Param("dto") CjDictItemDTO dto);

    IPage<CjDictItemVo> getPageList(Page<CjDictItemVo> page,@Param("dto")CjDictItemDTO dto);
}
