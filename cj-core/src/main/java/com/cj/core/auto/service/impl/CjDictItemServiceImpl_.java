package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjDictItemEntity;
import com.cj.core.auto.dto.CjDictItemDTO;
import com.cj.core.auto.mapper.CjDictItemMapper_;
import com.cj.core.auto.service.ICjDictItemService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 数据字典-子项 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjDictItemServiceImpl_ extends ServiceImpl<CjDictItemMapper_, CjDictItemEntity> implements ICjDictItemService_ {

@Override
public List<CjDictItemEntity> getList(CjDictItemDTO dto) {
 LambdaQueryWrapper<CjDictItemEntity> lambda=new LambdaQueryWrapper<CjDictItemEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjDictItemEntity::getId,dto.getId());
   }
   if(dto.getTypeId()!=null){
     lambda.eq(CjDictItemEntity::getTypeId,dto.getTypeId());
   }
   if(dto.getCode()!=null){
     lambda.eq(CjDictItemEntity::getCode,dto.getCode());
   }
   if(dto.getName()!=null){
     lambda.eq(CjDictItemEntity::getName,dto.getName());
   }
   if(dto.getOrderNum()!=null){
     lambda.eq(CjDictItemEntity::getOrderNum,dto.getOrderNum());
   }
   if(dto.getRemark()!=null){
     lambda.eq(CjDictItemEntity::getRemark,dto.getRemark());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjDictItemEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjDictItemEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjDictItemEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjDictItemEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjDictItemEntity> getPageList(CjDictItemDTO dto) {
    LambdaQueryWrapper<CjDictItemEntity> lambda=new LambdaQueryWrapper<CjDictItemEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjDictItemEntity::getId,dto.getId());
        }
        if(dto.getTypeId()!=null){
        lambda.eq(CjDictItemEntity::getTypeId,dto.getTypeId());
        }
        if(dto.getCode()!=null){
        lambda.eq(CjDictItemEntity::getCode,dto.getCode());
        }
        if(dto.getName()!=null){
        lambda.eq(CjDictItemEntity::getName,dto.getName());
        }
        if(dto.getOrderNum()!=null){
        lambda.eq(CjDictItemEntity::getOrderNum,dto.getOrderNum());
        }
        if(dto.getRemark()!=null){
        lambda.eq(CjDictItemEntity::getRemark,dto.getRemark());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjDictItemEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjDictItemEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjDictItemEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjDictItemEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjDictItemEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
