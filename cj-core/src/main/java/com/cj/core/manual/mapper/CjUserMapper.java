package com.cj.core.manual.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.auto.dto.CjUserDTO;
import com.cj.core.auto.entity.CjUserEntity;
import com.cj.core.auto.vo.CjMenuVo;
import com.cj.core.auto.vo.CjRoleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
    * 用户信息表 Mapper 接口
    * </p>
*
* @author lang.chaojin
* @since 2022-08-29
*/
@Service
public interface CjUserMapper extends BaseMapper<CjUserEntity> {

    List<CjRoleVo> getRoles(@Param("dto") CjUserDTO dto);
    List<CjMenuVo> getPerms(@Param("dto") CjUserDTO dto);
}
