package com.cj.core.manual.bllservice;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cj.common.vo.J;
import com.cj.core.auto.dto.CjGlobalConfigDTO;
import com.cj.core.auto.dto.CjMenuDTO;
import com.cj.core.auto.dto.CjUserConfigDTO;
import com.cj.core.auto.entity.CjGlobalConfigEntity;
import com.cj.core.auto.entity.CjMenuEntity;
import com.cj.core.auto.entity.CjUserConfigEntity;
import com.cj.core.auto.mapper.CjMenuMapper_;
import com.cj.core.auto.service.ICjGlobalConfigService_;
import com.cj.core.auto.service.ICjMenuService_;
import com.cj.core.auto.service.ICjUserConfigService_;
import com.cj.core.auto.service.impl.CjUserConfigServiceImpl_;
import com.cj.core.auto.vo.CjGlobalConfigVo;
import com.cj.core.auto.vo.CjUserConfigVo;
import com.cj.core.manual.mapper.CjUserMapper;
import com.cj.core.manual.vo.MenuNode;
import com.cj.core.utils.DozerUtils;
import com.cj.core.utils.TokenUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
    *  业务DAO
    * </p>
*
* @author lang.chaojin
* @since 2022-09-04
*/
@Service
public class CjConfigService {

    @Autowired
    ICjUserConfigService_ iCjUserConfigService_;

    @Autowired
    ICjGlobalConfigService_ iCjGlobalConfigService_;


    public List<CjUserConfigVo> getUserConfigList(CjUserConfigDTO dto){
//        LambdaQueryWrapper<CjUserConfigEntity> lambda=new LambdaQueryWrapper<CjUserConfigEntity>();
//        if(dto.getUsername()!=null){
//            lambda.eq(CjUserConfigEntity::getUsername,dto.getUsername());
//        }else{
//            lambda.eq(CjUserConfigEntity::getUsername, TokenUtils.getUserName());
//        }
//        if(dto.getGroupName()!=null){
//            lambda.eq(CjUserConfigEntity::getGroupName,dto.getGroupName());
//        }
//        if(dto.getConfigName()!=null){
//            lambda.eq(CjUserConfigEntity::getConfigName,dto.getConfigName());
//        }
        if(dto.getUsername()==null){
            dto.setUsername(TokenUtils.getUserName());
        }
        List<CjUserConfigEntity> list = iCjUserConfigService_.getList(dto);
        return DozerUtils.mapList(list,CjUserConfigVo.class);
    }

    public List<CjGlobalConfigVo> getGlobalConfigList(CjGlobalConfigDTO dto){
        LambdaQueryWrapper<CjGlobalConfigEntity> lambda=new LambdaQueryWrapper<CjGlobalConfigEntity>();
        if(dto.getGroupName()!=null){
            lambda.eq(CjGlobalConfigEntity::getGroupName,dto.getGroupName());
        }
        if(dto.getConfigName()!=null){
            lambda.eq(CjGlobalConfigEntity::getConfigName,dto.getConfigName());
        }
        List<CjGlobalConfigEntity> list = iCjGlobalConfigService_.list(lambda);
        return DozerUtils.mapList(list, CjGlobalConfigVo.class);
    }

}

