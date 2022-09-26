package ${package.Service};

import ${package.Entity}.${entity}Entity;
import ${package.Entity?replace('entity','dto')}.${entity?cap_first}DTO;
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
/**
* <p>
 * ${table.comment!} 接口服务类
 * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
@Primary
public interface ${table.serviceName}_ extends ${superServiceClass}<${entity}Entity> {
  public List<${entity}Entity> getList(${entity}DTO dto);
  public IPage<${entity}Entity> getPageList(${entity}DTO dto);
}
