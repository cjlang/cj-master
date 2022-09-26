package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjUserConfigEntity;
import com.cj.core.auto.dto.CjUserConfigDTO;
import com.cj.core.auto.mapper.CjUserConfigMapper_;
import com.cj.core.auto.service.ICjUserConfigService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 用户个性化配置 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjUserConfigServiceImpl_ extends ServiceImpl<CjUserConfigMapper_, CjUserConfigEntity> implements ICjUserConfigService_ {

@Override
public List<CjUserConfigEntity> getList(CjUserConfigDTO dto) {
 LambdaQueryWrapper<CjUserConfigEntity> lambda=new LambdaQueryWrapper<CjUserConfigEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjUserConfigEntity::getId,dto.getId());
   }
   if(dto.getUsername()!=null){
     lambda.eq(CjUserConfigEntity::getUsername,dto.getUsername());
   }
   if(dto.getGroupName()!=null){
     lambda.eq(CjUserConfigEntity::getGroupName,dto.getGroupName());
   }
   if(dto.getConfigName()!=null){
     lambda.eq(CjUserConfigEntity::getConfigName,dto.getConfigName());
   }
   if(dto.getConfigValue()!=null){
     lambda.eq(CjUserConfigEntity::getConfigValue,dto.getConfigValue());
   }
   if(dto.getActive()!=null){
     lambda.eq(CjUserConfigEntity::getActive,dto.getActive());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjUserConfigEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjUserConfigEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjUserConfigEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjUserConfigEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjUserConfigEntity> getPageList(CjUserConfigDTO dto) {
    LambdaQueryWrapper<CjUserConfigEntity> lambda=new LambdaQueryWrapper<CjUserConfigEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjUserConfigEntity::getId,dto.getId());
        }
        if(dto.getUsername()!=null){
        lambda.eq(CjUserConfigEntity::getUsername,dto.getUsername());
        }
        if(dto.getGroupName()!=null){
        lambda.eq(CjUserConfigEntity::getGroupName,dto.getGroupName());
        }
        if(dto.getConfigName()!=null){
        lambda.eq(CjUserConfigEntity::getConfigName,dto.getConfigName());
        }
        if(dto.getConfigValue()!=null){
        lambda.eq(CjUserConfigEntity::getConfigValue,dto.getConfigValue());
        }
        if(dto.getActive()!=null){
        lambda.eq(CjUserConfigEntity::getActive,dto.getActive());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjUserConfigEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjUserConfigEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjUserConfigEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjUserConfigEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjUserConfigEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
