package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjUserRoleVo;
import com.cj.core.auto.dto.CjUserRoleDTO;
import com.cj.core.auto.entity.CjUserRoleEntity;
import com.cj.core.auto.service.ICjUserRoleService_;
import com.cj.core.utils.DozerUtils;
import com.cj.core.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* <p>
    *  业务DAO
    * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjUserRoleBllService_ {

    @Autowired
    ICjUserRoleService_ iCjUserRoleService_;

    /**
    * 添加用户角色关系
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjUserRoleDTO dto) throws Exception {
        CjUserRoleEntity entity=DozerUtils.map(dto,CjUserRoleEntity.class);
        ValidationUtil.validate(entity);
        return  iCjUserRoleService_.save(entity);
    }

    /**
    * 删除用户角色关系
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjUserRoleService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新用户角色关系
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjUserRoleDTO dto) throws Exception {
        CjUserRoleEntity entity=DozerUtils.map(dto,CjUserRoleEntity.class);
        return  iCjUserRoleService_.updateById(entity);
    }

    /**
    * 查询用户角色关系列表
    * @return
    */
    public List<CjUserRoleVo> getList(CjUserRoleDTO dto){
        return  DozerUtils.mapList(iCjUserRoleService_.getList(dto),CjUserRoleVo.class);
    }

    /**
    * 获取Map分页用户角色关系
    * @return
    */
    public PageVO getPageList(CjUserRoleDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjUserRoleService_.getPageList(dto),CjUserRoleVo.class));
    }
}

