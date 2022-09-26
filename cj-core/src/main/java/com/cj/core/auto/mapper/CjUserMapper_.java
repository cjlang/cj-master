package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjUserDTO;
import com.cj.core.auto.vo.CjUserVo;
import com.cj.core.auto.entity.CjUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 用户信息 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjUserMapper_ extends BaseMapper<CjUserEntity> {

    List<CjUserVo> getList(@Param("dto") CjUserDTO dto);

    IPage<CjUserVo> getPageList(Page<CjUserVo> page,@Param("dto")CjUserDTO dto);
}
