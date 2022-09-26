package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjUserRoleDTO;
import com.cj.core.auto.vo.CjUserRoleVo;
import com.cj.core.auto.entity.CjUserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 用户角色关系 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjUserRoleMapper_ extends BaseMapper<CjUserRoleEntity> {

    List<CjUserRoleVo> getList(@Param("dto") CjUserRoleDTO dto);

    IPage<CjUserRoleVo> getPageList(Page<CjUserRoleVo> page,@Param("dto")CjUserRoleDTO dto);
}
