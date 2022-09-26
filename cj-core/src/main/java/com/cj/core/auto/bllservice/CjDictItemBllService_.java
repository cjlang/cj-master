package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjDictItemVo;
import com.cj.core.auto.dto.CjDictItemDTO;
import com.cj.core.auto.entity.CjDictItemEntity;
import com.cj.core.auto.service.ICjDictItemService_;
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
public class CjDictItemBllService_ {

    @Autowired
    ICjDictItemService_ iCjDictItemService_;

    /**
    * 添加数据字典-子项
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjDictItemDTO dto) throws Exception {
        CjDictItemEntity entity=DozerUtils.map(dto,CjDictItemEntity.class);
        ValidationUtil.validate(entity);
        return  iCjDictItemService_.save(entity);
    }

    /**
    * 删除数据字典-子项
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjDictItemService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新数据字典-子项
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjDictItemDTO dto) throws Exception {
        CjDictItemEntity entity=DozerUtils.map(dto,CjDictItemEntity.class);
        return  iCjDictItemService_.updateById(entity);
    }

    /**
    * 查询数据字典-子项列表
    * @return
    */
    public List<CjDictItemVo> getList(CjDictItemDTO dto){
        return  DozerUtils.mapList(iCjDictItemService_.getList(dto),CjDictItemVo.class);
    }

    /**
    * 获取Map分页数据字典-子项
    * @return
    */
    public PageVO getPageList(CjDictItemDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjDictItemService_.getPageList(dto),CjDictItemVo.class));
    }
}

