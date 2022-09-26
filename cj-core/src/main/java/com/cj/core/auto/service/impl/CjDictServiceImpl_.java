package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjDictEntity;
import com.cj.core.auto.dto.CjDictDTO;
import com.cj.core.auto.mapper.CjDictMapper_;
import com.cj.core.auto.service.ICjDictService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 数据字典 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjDictServiceImpl_ extends ServiceImpl<CjDictMapper_, CjDictEntity> implements ICjDictService_ {

@Override
public List<CjDictEntity> getList(CjDictDTO dto) {
 LambdaQueryWrapper<CjDictEntity> lambda=new LambdaQueryWrapper<CjDictEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjDictEntity::getId,dto.getId());
   }
   if(dto.getCode()!=null){
     lambda.eq(CjDictEntity::getCode,dto.getCode());
   }
   if(dto.getName()!=null){
     lambda.eq(CjDictEntity::getName,dto.getName());
   }
   if(dto.getOrderNum()!=null){
     lambda.eq(CjDictEntity::getOrderNum,dto.getOrderNum());
   }
   if(dto.getRemark()!=null){
     lambda.eq(CjDictEntity::getRemark,dto.getRemark());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjDictEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjDictEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjDictEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjDictEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjDictEntity> getPageList(CjDictDTO dto) {
    LambdaQueryWrapper<CjDictEntity> lambda=new LambdaQueryWrapper<CjDictEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjDictEntity::getId,dto.getId());
        }
        if(dto.getCode()!=null){
        lambda.eq(CjDictEntity::getCode,dto.getCode());
        }
        if(dto.getName()!=null){
        lambda.eq(CjDictEntity::getName,dto.getName());
        }
        if(dto.getOrderNum()!=null){
        lambda.eq(CjDictEntity::getOrderNum,dto.getOrderNum());
        }
        if(dto.getRemark()!=null){
        lambda.eq(CjDictEntity::getRemark,dto.getRemark());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjDictEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjDictEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjDictEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjDictEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjDictEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
