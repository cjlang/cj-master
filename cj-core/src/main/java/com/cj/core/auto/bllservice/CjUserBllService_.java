package com.cj.core.auto.bllservice;

import com.cj.common.valid.ValidationUtil;
import com.cj.core.auto.vo.CjUserVo;
import com.cj.core.auto.dto.CjUserDTO;
import com.cj.core.auto.entity.CjUserEntity;
import com.cj.core.auto.service.ICjUserService_;
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
public class CjUserBllService_ {

    @Autowired
    ICjUserService_ iCjUserService_;

    /**
    * 添加用户信息
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(CjUserDTO dto) throws Exception {
        CjUserEntity entity=DozerUtils.map(dto,CjUserEntity.class);
        ValidationUtil.validate(entity);
        return  iCjUserService_.save(entity);
    }

    /**
    * 删除用户信息
    * @param id
    * @return
    */
    public boolean del(String id){
        return  iCjUserService_.removeById(Long.valueOf(id));
    }

    /**
    * 更新用户信息
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(CjUserDTO dto) throws Exception {
        CjUserEntity entity=DozerUtils.map(dto,CjUserEntity.class);
        return  iCjUserService_.updateById(entity);
    }

    /**
    * 查询用户信息列表
    * @return
    */
    public List<CjUserVo> getList(CjUserDTO dto){
        return  DozerUtils.mapList(iCjUserService_.getList(dto),CjUserVo.class);
    }

    /**
    * 获取Map分页用户信息
    * @return
    */
    public PageVO getPageList(CjUserDTO dto){
        return  new PageVO(DozerUtils.pageList(iCjUserService_.getPageList(dto),CjUserVo.class));
    }
}

