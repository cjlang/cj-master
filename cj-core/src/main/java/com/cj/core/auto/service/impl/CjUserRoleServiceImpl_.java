package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjUserRoleEntity;
import com.cj.core.auto.dto.CjUserRoleDTO;
import com.cj.core.auto.mapper.CjUserRoleMapper_;
import com.cj.core.auto.service.ICjUserRoleService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 用户角色关系 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjUserRoleServiceImpl_ extends ServiceImpl<CjUserRoleMapper_, CjUserRoleEntity> implements ICjUserRoleService_ {

@Override
public List<CjUserRoleEntity> getList(CjUserRoleDTO dto) {
 LambdaQueryWrapper<CjUserRoleEntity> lambda=new LambdaQueryWrapper<CjUserRoleEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjUserRoleEntity::getId,dto.getId());
   }
   if(dto.getUserId()!=null){
     lambda.eq(CjUserRoleEntity::getUserId,dto.getUserId());
   }
   if(dto.getRoleId()!=null){
     lambda.eq(CjUserRoleEntity::getRoleId,dto.getRoleId());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjUserRoleEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjUserRoleEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjUserRoleEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjUserRoleEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjUserRoleEntity> getPageList(CjUserRoleDTO dto) {
    LambdaQueryWrapper<CjUserRoleEntity> lambda=new LambdaQueryWrapper<CjUserRoleEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjUserRoleEntity::getId,dto.getId());
        }
        if(dto.getUserId()!=null){
        lambda.eq(CjUserRoleEntity::getUserId,dto.getUserId());
        }
        if(dto.getRoleId()!=null){
        lambda.eq(CjUserRoleEntity::getRoleId,dto.getRoleId());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjUserRoleEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjUserRoleEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjUserRoleEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjUserRoleEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjUserRoleEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
