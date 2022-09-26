package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjDictDTO;
import com.cj.core.auto.vo.CjDictVo;
import com.cj.core.auto.entity.CjDictEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 数据字典 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjDictMapper_ extends BaseMapper<CjDictEntity> {

    List<CjDictVo> getList(@Param("dto") CjDictDTO dto);

    IPage<CjDictVo> getPageList(Page<CjDictVo> page,@Param("dto")CjDictDTO dto);
}
