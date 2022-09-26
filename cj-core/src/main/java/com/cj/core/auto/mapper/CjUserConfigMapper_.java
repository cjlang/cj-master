package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjUserConfigDTO;
import com.cj.core.auto.vo.CjUserConfigVo;
import com.cj.core.auto.entity.CjUserConfigEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 用户个性化配置 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjUserConfigMapper_ extends BaseMapper<CjUserConfigEntity> {

    List<CjUserConfigVo> getList(@Param("dto") CjUserConfigDTO dto);

    IPage<CjUserConfigVo> getPageList(Page<CjUserConfigVo> page,@Param("dto")CjUserConfigDTO dto);
}
