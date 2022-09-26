package com.cj.core.auto.mapper;

import com.cj.core.auto.dto.CjRoleMenuDTO;
import com.cj.core.auto.vo.CjRoleMenuVo;
import com.cj.core.auto.entity.CjRoleMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * 角色菜单关系 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public interface CjRoleMenuMapper_ extends BaseMapper<CjRoleMenuEntity> {

    List<CjRoleMenuVo> getList(@Param("dto") CjRoleMenuDTO dto);

    IPage<CjRoleMenuVo> getPageList(Page<CjRoleMenuVo> page,@Param("dto")CjRoleMenuDTO dto);
}
