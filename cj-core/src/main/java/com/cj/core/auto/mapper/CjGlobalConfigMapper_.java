package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjGlobalConfigDTO;
import com.cj.core.auto.vo.CjGlobalConfigVo;
import com.cj.core.auto.entity.CjGlobalConfigEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 系统全局配置 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjGlobalConfigMapper_ extends BaseMapper<CjGlobalConfigEntity> {

    List<CjGlobalConfigVo> getList(@Param("dto") CjGlobalConfigDTO dto);

    IPage<CjGlobalConfigVo> getPageList(Page<CjGlobalConfigVo> page,@Param("dto")CjGlobalConfigDTO dto);
}
