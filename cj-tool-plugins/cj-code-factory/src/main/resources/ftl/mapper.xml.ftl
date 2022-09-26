<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}_">
    <select id="getList" resultType="${package.Entity?replace('entity','vo')}.${entity}Vo">
        select * from ${table.name}
        <where>
            del_flag=0
            <#list table.fields as field>
            <#if field.name != 'del_flag'>
            <if test="dto!=null and dto.${field.propertyName}!=null and dto.${field.propertyName}!=''">
                and  ${field.name}=<#noparse>#{dto.</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
            </#if>
            </#list>
        </where>
    </select>
    <select id="getPageList" resultType="${package.Entity?replace('entity','vo')}.${entity}Vo">
        select * from ${table.name}
        <where>
            del_flag=0
            <#list table.fields as field>
            <#if field.name != 'del_flag'>
            <if test="dto!=null and dto.${field.propertyName}!=null and dto.${field.propertyName}!=''">
                and  ${field.name}=<#noparse>#{dto.</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
            </#if>
            </#list>
        </where>
    </select>
</mapper>
