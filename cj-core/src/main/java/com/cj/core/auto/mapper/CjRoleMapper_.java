package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjRoleDTO;
import com.cj.core.auto.vo.CjRoleVo;
import com.cj.core.auto.entity.CjRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 用户角色 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjRoleMapper_ extends BaseMapper<CjRoleEntity> {

    List<CjRoleVo> getList(@Param("dto") CjRoleDTO dto);

    IPage<CjRoleVo> getPageList(Page<CjRoleVo> page,@Param("dto")CjRoleDTO dto);
}
