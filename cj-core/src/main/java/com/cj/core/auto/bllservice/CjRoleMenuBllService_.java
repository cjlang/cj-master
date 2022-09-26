package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjRoleMenuVo;
import com.cj.core.auto.dto.CjRoleMenuDTO;
import com.cj.core.auto.entity.CjRoleMenuEntity;
import com.cj.core.auto.service.ICjRoleMenuService_;
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
public class CjRoleMenuBllService_ {

    @Autowired
    ICjRoleMenuService_ iCjRoleMenuService_;

    /**
    * 添加角色菜单关系
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjRoleMenuDTO dto) throws Exception {
        CjRoleMenuEntity entity=DozerUtils.map(dto,CjRoleMenuEntity.class);
        ValidationUtil.validate(entity);
        return  iCjRoleMenuService_.save(entity);
    }

    /**
    * 删除角色菜单关系
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjRoleMenuService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新角色菜单关系
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjRoleMenuDTO dto) throws Exception {
        CjRoleMenuEntity entity=DozerUtils.map(dto,CjRoleMenuEntity.class);
        return  iCjRoleMenuService_.updateById(entity);
    }

    /**
    * 查询角色菜单关系列表
    * @return
    */
    public List<CjRoleMenuVo> getList(CjRoleMenuDTO dto){
        return  DozerUtils.mapList(iCjRoleMenuService_.getList(dto),CjRoleMenuVo.class);
    }

    /**
    * 获取Map分页角色菜单关系
    * @return
    */
    public PageVO getPageList(CjRoleMenuDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjRoleMenuService_.getPageList(dto),CjRoleMenuVo.class));
    }
}

