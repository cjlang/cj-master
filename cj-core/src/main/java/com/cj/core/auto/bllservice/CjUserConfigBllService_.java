package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjUserConfigVo;
import com.cj.core.auto.dto.CjUserConfigDTO;
import com.cj.core.auto.entity.CjUserConfigEntity;
import com.cj.core.auto.service.ICjUserConfigService_;
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
public class CjUserConfigBllService_ {

    @Autowired
    ICjUserConfigService_ iCjUserConfigService_;

    /**
    * 添加用户个性化配置
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjUserConfigDTO dto) throws Exception {
        CjUserConfigEntity entity=DozerUtils.map(dto,CjUserConfigEntity.class);
        ValidationUtil.validate(entity);
        return  iCjUserConfigService_.save(entity);
    }

    /**
    * 删除用户个性化配置
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjUserConfigService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新用户个性化配置
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjUserConfigDTO dto) throws Exception {
        CjUserConfigEntity entity=DozerUtils.map(dto,CjUserConfigEntity.class);
        return  iCjUserConfigService_.updateById(entity);
    }

    /**
    * 查询用户个性化配置列表
    * @return
    */
    public List<CjUserConfigVo> getList(CjUserConfigDTO dto){
        return  DozerUtils.mapList(iCjUserConfigService_.getList(dto),CjUserConfigVo.class);
    }

    /**
    * 获取Map分页用户个性化配置
    * @return
    */
    public PageVO getPageList(CjUserConfigDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjUserConfigService_.getPageList(dto),CjUserConfigVo.class));
    }
}

