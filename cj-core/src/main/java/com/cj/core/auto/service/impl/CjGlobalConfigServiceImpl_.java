package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjGlobalConfigEntity;
import com.cj.core.auto.dto.CjGlobalConfigDTO;
import com.cj.core.auto.mapper.CjGlobalConfigMapper_;
import com.cj.core.auto.service.ICjGlobalConfigService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 系统全局配置 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjGlobalConfigServiceImpl_ extends ServiceImpl<CjGlobalConfigMapper_, CjGlobalConfigEntity> implements ICjGlobalConfigService_ {

@Override
public List<CjGlobalConfigEntity> getList(CjGlobalConfigDTO dto) {
 LambdaQueryWrapper<CjGlobalConfigEntity> lambda=new LambdaQueryWrapper<CjGlobalConfigEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjGlobalConfigEntity::getId,dto.getId());
   }
   if(dto.getGroupName()!=null){
     lambda.eq(CjGlobalConfigEntity::getGroupName,dto.getGroupName());
   }
   if(dto.getConfigName()!=null){
     lambda.eq(CjGlobalConfigEntity::getConfigName,dto.getConfigName());
   }
   if(dto.getConfigValue()!=null){
     lambda.eq(CjGlobalConfigEntity::getConfigValue,dto.getConfigValue());
   }
   if(dto.getActive()!=null){
     lambda.eq(CjGlobalConfigEntity::getActive,dto.getActive());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjGlobalConfigEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjGlobalConfigEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjGlobalConfigEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjGlobalConfigEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjGlobalConfigEntity> getPageList(CjGlobalConfigDTO dto) {
    LambdaQueryWrapper<CjGlobalConfigEntity> lambda=new LambdaQueryWrapper<CjGlobalConfigEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjGlobalConfigEntity::getId,dto.getId());
        }
        if(dto.getGroupName()!=null){
        lambda.eq(CjGlobalConfigEntity::getGroupName,dto.getGroupName());
        }
        if(dto.getConfigName()!=null){
        lambda.eq(CjGlobalConfigEntity::getConfigName,dto.getConfigName());
        }
        if(dto.getConfigValue()!=null){
        lambda.eq(CjGlobalConfigEntity::getConfigValue,dto.getConfigValue());
        }
        if(dto.getActive()!=null){
        lambda.eq(CjGlobalConfigEntity::getActive,dto.getActive());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjGlobalConfigEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjGlobalConfigEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjGlobalConfigEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjGlobalConfigEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjGlobalConfigEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
