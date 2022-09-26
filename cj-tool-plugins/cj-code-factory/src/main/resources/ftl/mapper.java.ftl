package ${package.Mapper};

import ${package.Entity?replace('entity','dto')}.${entity?cap_first}DTO;
import ${package.Entity?replace('entity','vo')}.${entity}Vo;
import ${package.Entity}.${entity}Entity;
import ${superMapperClassPackage};
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
    * ${table.comment!} Mapper 接口
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
public interface ${table.mapperName}_ extends ${superMapperClass}<${entity}Entity> {

    List<${entity}Vo> getList(@Param("dto") ${entity}DTO dto);

    IPage<${entity}Vo> getPageList(Page<${entity}Vo> page,@Param("dto")${entity}DTO dto);
}
