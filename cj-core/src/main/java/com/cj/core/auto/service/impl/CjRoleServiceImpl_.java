package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjRoleEntity;
import com.cj.core.auto.dto.CjRoleDTO;
import com.cj.core.auto.mapper.CjRoleMapper_;
import com.cj.core.auto.service.ICjRoleService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 用户角色 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjRoleServiceImpl_ extends ServiceImpl<CjRoleMapper_, CjRoleEntity> implements ICjRoleService_ {

@Override
public List<CjRoleEntity> getList(CjRoleDTO dto) {
 LambdaQueryWrapper<CjRoleEntity> lambda=new LambdaQueryWrapper<CjRoleEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjRoleEntity::getId,dto.getId());
   }
   if(dto.getCode()!=null){
     lambda.eq(CjRoleEntity::getCode,dto.getCode());
   }
   if(dto.getName()!=null){
     lambda.eq(CjRoleEntity::getName,dto.getName());
   }
   if(dto.getType()!=null){
     lambda.eq(CjRoleEntity::getType,dto.getType());
   }
   if(dto.getOrderNum()!=null){
     lambda.eq(CjRoleEntity::getOrderNum,dto.getOrderNum());
   }
   if(dto.getRemark()!=null){
     lambda.eq(CjRoleEntity::getRemark,dto.getRemark());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjRoleEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjRoleEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjRoleEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjRoleEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjRoleEntity> getPageList(CjRoleDTO dto) {
    LambdaQueryWrapper<CjRoleEntity> lambda=new LambdaQueryWrapper<CjRoleEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjRoleEntity::getId,dto.getId());
        }
        if(dto.getCode()!=null){
        lambda.eq(CjRoleEntity::getCode,dto.getCode());
        }
        if(dto.getName()!=null){
        lambda.eq(CjRoleEntity::getName,dto.getName());
        }
        if(dto.getType()!=null){
        lambda.eq(CjRoleEntity::getType,dto.getType());
        }
        if(dto.getOrderNum()!=null){
        lambda.eq(CjRoleEntity::getOrderNum,dto.getOrderNum());
        }
        if(dto.getRemark()!=null){
        lambda.eq(CjRoleEntity::getRemark,dto.getRemark());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjRoleEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjRoleEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjRoleEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjRoleEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjRoleEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
