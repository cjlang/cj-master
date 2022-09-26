package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjRoleVo;
import com.cj.core.auto.dto.CjRoleDTO;
import com.cj.core.auto.entity.CjRoleEntity;
import com.cj.core.auto.service.ICjRoleService_;
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
public class CjRoleBllService_ {

    @Autowired
    ICjRoleService_ iCjRoleService_;

    /**
    * 添加用户角色
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjRoleDTO dto) throws Exception {
        CjRoleEntity entity=DozerUtils.map(dto,CjRoleEntity.class);
        ValidationUtil.validate(entity);
        return  iCjRoleService_.save(entity);
    }

    /**
    * 删除用户角色
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjRoleService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新用户角色
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjRoleDTO dto) throws Exception {
        CjRoleEntity entity=DozerUtils.map(dto,CjRoleEntity.class);
        return  iCjRoleService_.updateById(entity);
    }

    /**
    * 查询用户角色列表
    * @return
    */
    public List<CjRoleVo> getList(CjRoleDTO dto){
        return  DozerUtils.mapList(iCjRoleService_.getList(dto),CjRoleVo.class);
    }

    /**
    * 获取Map分页用户角色
    * @return
    */
    public PageVO getPageList(CjRoleDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjRoleService_.getPageList(dto),CjRoleVo.class));
    }
}

