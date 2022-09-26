package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjUserEntity;
import com.cj.core.auto.dto.CjUserDTO;
import com.cj.core.auto.mapper.CjUserMapper_;
import com.cj.core.auto.service.ICjUserService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 用户信息 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjUserServiceImpl_ extends ServiceImpl<CjUserMapper_, CjUserEntity> implements ICjUserService_ {

@Override
public List<CjUserEntity> getList(CjUserDTO dto) {
 LambdaQueryWrapper<CjUserEntity> lambda=new LambdaQueryWrapper<CjUserEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjUserEntity::getId,dto.getId());
   }
   if(dto.getUsername()!=null){
     lambda.eq(CjUserEntity::getUsername,dto.getUsername());
   }
   if(dto.getPassword()!=null){
     lambda.eq(CjUserEntity::getPassword,dto.getPassword());
   }
   if(dto.getRealName()!=null){
     lambda.eq(CjUserEntity::getRealName,dto.getRealName());
   }
   if(dto.getStatus()!=null){
     lambda.eq(CjUserEntity::getStatus,dto.getStatus());
   }
   if(dto.getPwdExpireDate()!=null){
     lambda.eq(CjUserEntity::getPwdExpireDate,dto.getPwdExpireDate());
   }
   if(dto.getLastPwdUpdateDate()!=null){
     lambda.eq(CjUserEntity::getLastPwdUpdateDate,dto.getLastPwdUpdateDate());
   }
   if(dto.getLastLoginDate()!=null){
     lambda.eq(CjUserEntity::getLastLoginDate,dto.getLastLoginDate());
   }
   if(dto.getLastLoginIp()!=null){
     lambda.eq(CjUserEntity::getLastLoginIp,dto.getLastLoginIp());
   }
   if(dto.getOrgId()!=null){
     lambda.eq(CjUserEntity::getOrgId,dto.getOrgId());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjUserEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjUserEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjUserEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjUserEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjUserEntity> getPageList(CjUserDTO dto) {
    LambdaQueryWrapper<CjUserEntity> lambda=new LambdaQueryWrapper<CjUserEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjUserEntity::getId,dto.getId());
        }
        if(dto.getUsername()!=null){
        lambda.eq(CjUserEntity::getUsername,dto.getUsername());
        }
        if(dto.getPassword()!=null){
        lambda.eq(CjUserEntity::getPassword,dto.getPassword());
        }
        if(dto.getRealName()!=null){
        lambda.eq(CjUserEntity::getRealName,dto.getRealName());
        }
        if(dto.getStatus()!=null){
        lambda.eq(CjUserEntity::getStatus,dto.getStatus());
        }
        if(dto.getPwdExpireDate()!=null){
        lambda.eq(CjUserEntity::getPwdExpireDate,dto.getPwdExpireDate());
        }
        if(dto.getLastPwdUpdateDate()!=null){
        lambda.eq(CjUserEntity::getLastPwdUpdateDate,dto.getLastPwdUpdateDate());
        }
        if(dto.getLastLoginDate()!=null){
        lambda.eq(CjUserEntity::getLastLoginDate,dto.getLastLoginDate());
        }
        if(dto.getLastLoginIp()!=null){
        lambda.eq(CjUserEntity::getLastLoginIp,dto.getLastLoginIp());
        }
        if(dto.getOrgId()!=null){
        lambda.eq(CjUserEntity::getOrgId,dto.getOrgId());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjUserEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjUserEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjUserEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjUserEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjUserEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
