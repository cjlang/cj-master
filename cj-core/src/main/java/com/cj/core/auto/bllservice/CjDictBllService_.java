package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjDictVo;
import com.cj.core.auto.dto.CjDictDTO;
import com.cj.core.auto.entity.CjDictEntity;
import com.cj.core.auto.service.ICjDictService_;
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
public class CjDictBllService_ {

    @Autowired
    ICjDictService_ iCjDictService_;

    /**
    * 添加数据字典
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjDictDTO dto) throws Exception {
        CjDictEntity entity=DozerUtils.map(dto,CjDictEntity.class);
        ValidationUtil.validate(entity);
        return  iCjDictService_.save(entity);
    }

    /**
    * 删除数据字典
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjDictService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新数据字典
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjDictDTO dto) throws Exception {
        CjDictEntity entity=DozerUtils.map(dto,CjDictEntity.class);
        return  iCjDictService_.updateById(entity);
    }

    /**
    * 查询数据字典列表
    * @return
    */
    public List<CjDictVo> getList(CjDictDTO dto){
        return  DozerUtils.mapList(iCjDictService_.getList(dto),CjDictVo.class);
    }

    /**
    * 获取Map分页数据字典
    * @return
    */
    public PageVO getPageList(CjDictDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjDictService_.getPageList(dto),CjDictVo.class));
    }
}

