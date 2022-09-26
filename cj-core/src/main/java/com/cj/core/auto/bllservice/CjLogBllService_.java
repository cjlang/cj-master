package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjLogVo;
import com.cj.core.auto.dto.CjLogDTO;
import com.cj.core.auto.entity.CjLogEntity;
import com.cj.core.auto.service.ICjLogService_;
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
public class CjLogBllService_ {

    @Autowired
    ICjLogService_ iCjLogService_;

    /**
    * 添加业务日志
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjLogDTO dto) throws Exception {
        CjLogEntity entity=DozerUtils.map(dto,CjLogEntity.class);
        ValidationUtil.validate(entity);
        return  iCjLogService_.save(entity);
    }

    /**
    * 删除业务日志
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjLogService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新业务日志
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjLogDTO dto) throws Exception {
        CjLogEntity entity=DozerUtils.map(dto,CjLogEntity.class);
        return  iCjLogService_.updateById(entity);
    }

    /**
    * 查询业务日志列表
    * @return
    */
    public List<CjLogVo> getList(CjLogDTO dto){
        return  DozerUtils.mapList(iCjLogService_.getList(dto),CjLogVo.class);
    }

    /**
    * 获取Map分页业务日志
    * @return
    */
    public PageVO getPageList(CjLogDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjLogService_.getPageList(dto),CjLogVo.class));
    }
}

