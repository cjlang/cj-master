package ${package.Entity?replace('entity','')}bllservice;

import com.cj.common.valid.ValidationUtil;
import ${package.Entity?replace('entity','vo')}.${entity?cap_first}Vo;
import ${package.Entity?replace('entity','dto')}.${entity?cap_first}DTO;
import ${package.Entity}.${entity?cap_first}Entity;
import ${package.Service}.${table.serviceName}_;
import com.cj.core.utils.DozerUtils;
import com.cj.core.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* <p>
    *  业务DAO
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
public class ${entity?cap_first}BllService_ {

    @Autowired
    ${table.serviceName}_ ${table.serviceName?uncap_first}_;

    /**
    * 添加${table.comment!}
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean add(${entity?cap_first}DTO dto) throws Exception {
        ${entity?cap_first}Entity entity=DozerUtils.map(dto,${entity?cap_first}Entity.class);
        ValidationUtil.validate(entity);
        return  ${table.serviceName?uncap_first}_.save(entity);
    }

    /**
    * 删除${table.comment!}
    * @param id
    * @return
    */
    public boolean del(String id){
        return  ${table.serviceName?uncap_first}_.removeById(Long.valueOf(id));
    }

    /**
    * 更新${table.comment!}
    * @param dto
    * @return
    * @throws Exception
    */
    public boolean update(${entity?cap_first}DTO dto) throws Exception {
        ${entity?cap_first}Entity entity=DozerUtils.map(dto,${entity?cap_first}Entity.class);
        return  ${table.serviceName?uncap_first}_.updateById(entity);
    }

    /**
    * 查询${table.comment!}列表
    * @return
    */
    public List<${entity?cap_first}Vo> getList(${entity?cap_first}DTO dto){
        return  DozerUtils.mapList(${table.serviceName?uncap_first}_.getList(dto),${entity?cap_first}Vo.class);
    }

    /**
    * 获取Map分页${table.comment!}
    * @return
    */
    public PageVO getPageList(${entity?cap_first}DTO dto){
        return  new PageVO(DozerUtils.pageList(${table.serviceName?uncap_first}_.getPageList(dto),${entity?cap_first}Vo.class));
    }
}

