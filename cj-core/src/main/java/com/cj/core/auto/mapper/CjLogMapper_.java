package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjLogDTO;
import com.cj.core.auto.vo.CjLogVo;
import com.cj.core.auto.entity.CjLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 业务日志 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjLogMapper_ extends BaseMapper<CjLogEntity> {

    List<CjLogVo> getList(@Param("dto") CjLogDTO dto);

    IPage<CjLogVo> getPageList(Page<CjLogVo> page,@Param("dto")CjLogDTO dto);
}
