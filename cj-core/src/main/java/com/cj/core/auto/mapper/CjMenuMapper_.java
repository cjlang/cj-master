package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjMenuDTO;
import com.cj.core.auto.vo.CjMenuVo;
import com.cj.core.auto.entity.CjMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 系统菜单 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjMenuMapper_ extends BaseMapper<CjMenuEntity> {

    List<CjMenuVo> getList(@Param("dto") CjMenuDTO dto);

    IPage<CjMenuVo> getPageList(Page<CjMenuVo> page,@Param("dto")CjMenuDTO dto);
}
