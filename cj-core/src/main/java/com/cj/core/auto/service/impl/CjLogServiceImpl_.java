package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjLogEntity;
import com.cj.core.auto.dto.CjLogDTO;
import com.cj.core.auto.mapper.CjLogMapper_;
import com.cj.core.auto.service.ICjLogService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 业务日志 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjLogServiceImpl_ extends ServiceImpl<CjLogMapper_, CjLogEntity> implements ICjLogService_ {

@Override
public List<CjLogEntity> getList(CjLogDTO dto) {
 LambdaQueryWrapper<CjLogEntity> lambda=new LambdaQueryWrapper<CjLogEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjLogEntity::getId,dto.getId());
   }
   if(dto.getBllModule()!=null){
     lambda.eq(CjLogEntity::getBllModule,dto.getBllModule());
   }
   if(dto.getSessionId()!=null){
     lambda.eq(CjLogEntity::getSessionId,dto.getSessionId());
   }
   if(dto.getThreadId()!=null){
     lambda.eq(CjLogEntity::getThreadId,dto.getThreadId());
   }
   if(dto.getCalssInfo()!=null){
     lambda.eq(CjLogEntity::getCalssInfo,dto.getCalssInfo());
   }
   if(dto.getContent()!=null){
     lambda.eq(CjLogEntity::getContent,dto.getContent());
   }
   if(dto.getLogTime()!=null){
     lambda.eq(CjLogEntity::getLogTime,dto.getLogTime());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjLogEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjLogEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjLogEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjLogEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjLogEntity> getPageList(CjLogDTO dto) {
    LambdaQueryWrapper<CjLogEntity> lambda=new LambdaQueryWrapper<CjLogEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjLogEntity::getId,dto.getId());
        }
        if(dto.getBllModule()!=null){
        lambda.eq(CjLogEntity::getBllModule,dto.getBllModule());
        }
        if(dto.getSessionId()!=null){
        lambda.eq(CjLogEntity::getSessionId,dto.getSessionId());
        }
        if(dto.getThreadId()!=null){
        lambda.eq(CjLogEntity::getThreadId,dto.getThreadId());
        }
        if(dto.getCalssInfo()!=null){
        lambda.eq(CjLogEntity::getCalssInfo,dto.getCalssInfo());
        }
        if(dto.getContent()!=null){
        lambda.eq(CjLogEntity::getContent,dto.getContent());
        }
        if(dto.getLogTime()!=null){
        lambda.eq(CjLogEntity::getLogTime,dto.getLogTime());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjLogEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjLogEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjLogEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjLogEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjLogEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
