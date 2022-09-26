package com.cj.core.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.auto.entity.CjMenuEntity;
import com.cj.core.auto.dto.CjMenuDTO;
import com.cj.core.auto.mapper.CjMenuMapper_;
import com.cj.core.auto.service.ICjMenuService_;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * 系统菜单 接口服务实现类
 * </p>
*
* @author lang.chaojin
* @since 2022-09-15
*/
@Service
public class CjMenuServiceImpl_ extends ServiceImpl<CjMenuMapper_, CjMenuEntity> implements ICjMenuService_ {

@Override
public List<CjMenuEntity> getList(CjMenuDTO dto) {
 LambdaQueryWrapper<CjMenuEntity> lambda=new LambdaQueryWrapper<CjMenuEntity>();
   if(dto.getId()!=null){
     lambda.eq(CjMenuEntity::getId,dto.getId());
   }
   if(dto.getType()!=null){
     lambda.eq(CjMenuEntity::getType,dto.getType());
   }
   if(dto.getMenuCode()!=null){
     lambda.eq(CjMenuEntity::getMenuCode,dto.getMenuCode());
   }
   if(dto.getPid()!=null){
     lambda.eq(CjMenuEntity::getPid,dto.getPid());
   }
   if(dto.getLevel()!=null){
     lambda.eq(CjMenuEntity::getLevel,dto.getLevel());
   }
   if(dto.getMenuName()!=null){
     lambda.eq(CjMenuEntity::getMenuName,dto.getMenuName());
   }
   if(dto.getUrlPath()!=null){
     lambda.eq(CjMenuEntity::getUrlPath,dto.getUrlPath());
   }
   if(dto.getComponent()!=null){
     lambda.eq(CjMenuEntity::getComponent,dto.getComponent());
   }
   if(dto.getIframe()!=null){
     lambda.eq(CjMenuEntity::getIframe,dto.getIframe());
   }
   if(dto.getIframePath()!=null){
     lambda.eq(CjMenuEntity::getIframePath,dto.getIframePath());
   }
   if(dto.getIcon()!=null){
     lambda.eq(CjMenuEntity::getIcon,dto.getIcon());
   }
   if(dto.getLayerX()!=null){
     lambda.eq(CjMenuEntity::getLayerX,dto.getLayerX());
   }
   if(dto.getLayerY()!=null){
     lambda.eq(CjMenuEntity::getLayerY,dto.getLayerY());
   }
   if(dto.getWidth()!=null){
     lambda.eq(CjMenuEntity::getWidth,dto.getWidth());
   }
   if(dto.getHeight()!=null){
     lambda.eq(CjMenuEntity::getHeight,dto.getHeight());
   }
   if(dto.getMinWidth()!=null){
     lambda.eq(CjMenuEntity::getMinWidth,dto.getMinWidth());
   }
   if(dto.getMinHeight()!=null){
     lambda.eq(CjMenuEntity::getMinHeight,dto.getMinHeight());
   }
   if(dto.getSysWindow()!=null){
     lambda.eq(CjMenuEntity::getSysWindow,dto.getSysWindow());
   }
   if(dto.getIconColor()!=null){
     lambda.eq(CjMenuEntity::getIconColor,dto.getIconColor());
   }
   if(dto.getImgOrIcon()!=null){
     lambda.eq(CjMenuEntity::getImgOrIcon,dto.getImgOrIcon());
   }
   if(dto.getImgUrl()!=null){
     lambda.eq(CjMenuEntity::getImgUrl,dto.getImgUrl());
   }
   if(dto.getSpan()!=null){
     lambda.eq(CjMenuEntity::getSpan,dto.getSpan());
   }
   if(dto.getOrderNum()!=null){
     lambda.eq(CjMenuEntity::getOrderNum,dto.getOrderNum());
   }
   if(dto.getRemark()!=null){
     lambda.eq(CjMenuEntity::getRemark,dto.getRemark());
   }
   if(dto.getCreateDate()!=null){
     lambda.eq(CjMenuEntity::getCreateDate,dto.getCreateDate());
   }
   if(dto.getCreateBy()!=null){
     lambda.eq(CjMenuEntity::getCreateBy,dto.getCreateBy());
   }
   if(dto.getUpdateBy()!=null){
     lambda.eq(CjMenuEntity::getUpdateBy,dto.getUpdateBy());
   }
   if(dto.getUpdateDate()!=null){
     lambda.eq(CjMenuEntity::getUpdateDate,dto.getUpdateDate());
   }
   return this.list(lambda);
   }

   @Override
   public IPage<CjMenuEntity> getPageList(CjMenuDTO dto) {
    LambdaQueryWrapper<CjMenuEntity> lambda=new LambdaQueryWrapper<CjMenuEntity>();
        if(dto.getId()!=null){
        lambda.eq(CjMenuEntity::getId,dto.getId());
        }
        if(dto.getType()!=null){
        lambda.eq(CjMenuEntity::getType,dto.getType());
        }
        if(dto.getMenuCode()!=null){
        lambda.eq(CjMenuEntity::getMenuCode,dto.getMenuCode());
        }
        if(dto.getPid()!=null){
        lambda.eq(CjMenuEntity::getPid,dto.getPid());
        }
        if(dto.getLevel()!=null){
        lambda.eq(CjMenuEntity::getLevel,dto.getLevel());
        }
        if(dto.getMenuName()!=null){
        lambda.eq(CjMenuEntity::getMenuName,dto.getMenuName());
        }
        if(dto.getUrlPath()!=null){
        lambda.eq(CjMenuEntity::getUrlPath,dto.getUrlPath());
        }
        if(dto.getComponent()!=null){
        lambda.eq(CjMenuEntity::getComponent,dto.getComponent());
        }
        if(dto.getIframe()!=null){
        lambda.eq(CjMenuEntity::getIframe,dto.getIframe());
        }
        if(dto.getIframePath()!=null){
        lambda.eq(CjMenuEntity::getIframePath,dto.getIframePath());
        }
        if(dto.getIcon()!=null){
        lambda.eq(CjMenuEntity::getIcon,dto.getIcon());
        }
        if(dto.getLayerX()!=null){
        lambda.eq(CjMenuEntity::getLayerX,dto.getLayerX());
        }
        if(dto.getLayerY()!=null){
        lambda.eq(CjMenuEntity::getLayerY,dto.getLayerY());
        }
        if(dto.getWidth()!=null){
        lambda.eq(CjMenuEntity::getWidth,dto.getWidth());
        }
        if(dto.getHeight()!=null){
        lambda.eq(CjMenuEntity::getHeight,dto.getHeight());
        }
        if(dto.getMinWidth()!=null){
        lambda.eq(CjMenuEntity::getMinWidth,dto.getMinWidth());
        }
        if(dto.getMinHeight()!=null){
        lambda.eq(CjMenuEntity::getMinHeight,dto.getMinHeight());
        }
        if(dto.getSysWindow()!=null){
        lambda.eq(CjMenuEntity::getSysWindow,dto.getSysWindow());
        }
        if(dto.getIconColor()!=null){
        lambda.eq(CjMenuEntity::getIconColor,dto.getIconColor());
        }
        if(dto.getImgOrIcon()!=null){
        lambda.eq(CjMenuEntity::getImgOrIcon,dto.getImgOrIcon());
        }
        if(dto.getImgUrl()!=null){
        lambda.eq(CjMenuEntity::getImgUrl,dto.getImgUrl());
        }
        if(dto.getSpan()!=null){
        lambda.eq(CjMenuEntity::getSpan,dto.getSpan());
        }
        if(dto.getOrderNum()!=null){
        lambda.eq(CjMenuEntity::getOrderNum,dto.getOrderNum());
        }
        if(dto.getRemark()!=null){
        lambda.eq(CjMenuEntity::getRemark,dto.getRemark());
        }
        if(dto.getCreateDate()!=null){
        lambda.eq(CjMenuEntity::getCreateDate,dto.getCreateDate());
        }
        if(dto.getCreateBy()!=null){
        lambda.eq(CjMenuEntity::getCreateBy,dto.getCreateBy());
        }
        if(dto.getUpdateBy()!=null){
        lambda.eq(CjMenuEntity::getUpdateBy,dto.getUpdateBy());
        }
        if(dto.getUpdateDate()!=null){
        lambda.eq(CjMenuEntity::getUpdateDate,dto.getUpdateDate());
        }
      return this.page(new Page<CjMenuEntity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
