package com.cj.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import java.util.Date;

public class MpBaseHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasGetter("createBy"))
        {
            this.setFieldValByName("createBy", 0L,metaObject);
        }
        if (metaObject.hasGetter("createDate"))
        {
            this.setFieldValByName("createDate", new Date(),metaObject);
        }
        if (metaObject.hasGetter("updateDate"))
        {
            this.setFieldValByName("updateDate", new Date(),metaObject);
        }
        if (metaObject.hasGetter("updateBy"))
        {
            this.setFieldValByName("updateBy", 0L,metaObject);
        }
        if (metaObject.hasGetter("delFlag"))
        {
            this.setFieldValByName("delFlag", 0,metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("createBy"))
        {
            this.setFieldValByName("createBy", 0L,metaObject);
        }
        if (metaObject.hasGetter("createDate"))
        {
            this.setFieldValByName("createDate", new Date(),metaObject);
        }
        if (metaObject.hasGetter("updateBy"))
        {
            this.setFieldValByName("updateBy", 0L,metaObject);
        }
        if (metaObject.hasGetter("updateDate"))
        {
            this.setFieldValByName("updateDate", new Date(),metaObject);
        }
        if (metaObject.hasGetter("delFlag"))
        {
            this.setFieldValByName("delFlag", 0,metaObject);
        }
    }
}
