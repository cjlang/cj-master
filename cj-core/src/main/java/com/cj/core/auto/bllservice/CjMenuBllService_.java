package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjMenuVo;
import com.cj.core.auto.dto.CjMenuDTO;
import com.cj.core.auto.entity.CjMenuEntity;
import com.cj.core.auto.service.ICjMenuService_;
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
public class CjMenuBllService_ {

    @Autowired
    ICjMenuService_ iCjMenuService_;

    /**
    * 添加系统菜单
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjMenuDTO dto) throws Exception {
        CjMenuEntity entity=DozerUtils.map(dto,CjMenuEntity.class);
        ValidationUtil.validate(entity);
        return  iCjMenuService_.save(entity);
    }

    /**
    * 删除系统菜单
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjMenuService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新系统菜单
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjMenuDTO dto) throws Exception {
        CjMenuEntity entity=DozerUtils.map(dto,CjMenuEntity.class);
        return  iCjMenuService_.updateById(entity);
    }

    /**
    * 查询系统菜单列表
    * @return
    */
    public List<CjMenuVo> getList(CjMenuDTO dto){
        return  DozerUtils.mapList(iCjMenuService_.getList(dto),CjMenuVo.class);
    }

    /**
    * 获取Map分页系统菜单
    * @return
    */
    public PageVO getPageList(CjMenuDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjMenuService_.getPageList(dto),CjMenuVo.class));
    }
}

