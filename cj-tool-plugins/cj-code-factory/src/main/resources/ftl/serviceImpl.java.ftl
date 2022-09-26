package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity}Entity;
import ${package.Entity?replace('entity','dto')}.${entity?cap_first}DTO;
import ${package.Mapper}.${table.mapperName}_;
import ${package.Service}.${table.serviceName}_;
import ${superServiceImplClassPackage};
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


/**
* <p>
 * ${table.comment!} 接口服务实现类
 * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
public class ${table.serviceImplName}_ extends ${superServiceImplClass}<${table.mapperName}_, ${entity}Entity> implements ${table.serviceName}_ {

@Override
public List<${entity}Entity> getList(${entity}DTO dto) {
 LambdaQueryWrapper<${entity}Entity> lambda=new LambdaQueryWrapper<${entity}Entity>();
   <#list table.fields as field>
   <#if field.name != 'del_flag'>
   if(dto.get${field.propertyName?cap_first}()!=null){
     lambda.eq(${entity}Entity::get${field.propertyName?cap_first},dto.get${field.propertyName?cap_first}());
   }
   </#if>
   </#list>
   return this.list(lambda);
   }

   @Override
   public IPage<${entity}Entity> getPageList(${entity}DTO dto) {
    LambdaQueryWrapper<${entity}Entity> lambda=new LambdaQueryWrapper<${entity}Entity>();
      <#list table.fields as field>
       <#if field.name != 'del_flag'>
        if(dto.get${field.propertyName?cap_first}()!=null){
        lambda.eq(${entity}Entity::get${field.propertyName?cap_first},dto.get${field.propertyName?cap_first}());
        }
       </#if>
      </#list>
      return this.page(new Page<${entity}Entity>(dto.getCurrentpage(), dto.getPagesize()), lambda);
    }
}
