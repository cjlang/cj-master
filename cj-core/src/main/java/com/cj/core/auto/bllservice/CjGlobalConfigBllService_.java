package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjGlobalConfigVo;
import com.cj.core.auto.dto.CjGlobalConfigDTO;
import com.cj.core.auto.entity.CjGlobalConfigEntity;
import com.cj.core.auto.service.ICjGlobalConfigService_;
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
public class CjGlobalConfigBllService_ {

    @Autowired
    ICjGlobalConfigService_ iCjGlobalConfigService_;

    /**
    * 添加系统全局配置
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjGlobalConfigDTO dto) throws Exception {
        CjGlobalConfigEntity entity=DozerUtils.map(dto,CjGlobalConfigEntity.class);
        ValidationUtil.validate(entity);
        return  iCjGlobalConfigService_.save(entity);
    }

    /**
    * 删除系统全局配置
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjGlobalConfigService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新系统全局配置
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjGlobalConfigDTO dto) throws Exception {
        CjGlobalConfigEntity entity=DozerUtils.map(dto,CjGlobalConfigEntity.class);
        return  iCjGlobalConfigService_.updateById(entity);
    }

    /**
    * 查询系统全局配置列表
    * @return
    */
    public List<CjGlobalConfigVo> getList(CjGlobalConfigDTO dto){
        return  DozerUtils.mapList(iCjGlobalConfigService_.getList(dto),CjGlobalConfigVo.class);
    }

    /**
    * 获取Map分页系统全局配置
    * @return
    */
    public PageVO getPageList(CjGlobalConfigDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjGlobalConfigService_.getPageList(dto),CjGlobalConfigVo.class));
    }
}

