package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjRoleMenuEntity;
import com.cj.core.auto.dto.CjRoleMenuDTO;
import com.cj.core.auto.mapper.CjRoleMenuMapper_;
import com.cj.core.auto.service.ICjRoleMenuService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 角色菜单关系 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjRoleMenuServiceImpl_ extends ServiceImpl<CjRoleMenuMapper_, CjRoleMenuEntity> implements ICjRoleMenuService_ {

@Override
public List<CjRoleMenuEntity> getList(CjRoleMenuDTO dto) {
 LambdaQueryWrapper<CjRoleMenuEntity> lambda=new LambdaQueryWrapper<CjRoleMenuEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjRoleMenuEntity::getId,dto.getId());
   }
   if(dto.getRoleId()!=null){
     lambda.eq(CjRoleMenuEntity::getRoleId,dto.getRoleId());
   }
   if(dto.getMenuId()!=null){
     lambda.eq(CjRoleMenuEntity::getMenuId,dto.getMenuId());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjRoleMenuEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjRoleMenuEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjRoleMenuEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjRoleMenuEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjRoleMenuEntity> getPageList(CjRoleMenuDTO dto) {
    LambdaQueryWrapper<CjRoleMenuEntity> lambda=new LambdaQueryWrapper<CjRoleMenuEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjRoleMenuEntity::getId,dto.getId());
        }
        if(dto.getRoleId()!=null){
        lambda.eq(CjRoleMenuEntity::getRoleId,dto.getRoleId());
        }
        if(dto.getMenuId()!=null){
        lambda.eq(CjRoleMenuEntity::getMenuId,dto.getMenuId());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjRoleMenuEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjRoleMenuEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjRoleMenuEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjRoleMenuEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjRoleMenuEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
