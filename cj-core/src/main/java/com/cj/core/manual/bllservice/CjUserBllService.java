package com.cj.core.manual.bllservice;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cj.core.auto.dto.CjUserDTO;
import com.cj.core.auto.entity.CjUserEntity;
import com.cj.core.auto.vo.CjMenuVo;
import com.cj.core.auto.vo.CjRoleVo;
import com.cj.core.manual.mapper.CjUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* <p>
    *  业务DAO
    * </p>
*
* @author lang.chaojin
* @since 2022-08-29
*/
@Service
public class CjUserBllService {
    @Autowired
    CjUserMapper cjUserMapper;

    /**
     * 通过用户名查询信息
     * @param userName
     * @return
     * @throws Exception
     */
    public CjUserEntity getUserByName(String userName) throws Exception {
        return cjUserMapper.selectOne(new LambdaQueryWrapper<CjUserEntity>().eq(CjUserEntity::getUsername,userName));
    }

    public List<CjRoleVo> getRolesByName(String userName){
        CjUserDTO cjUserDTO=new CjUserDTO();
        cjUserDTO.setUsername(userName);
        return cjUserMapper.getRoles(cjUserDTO);
    }

    public List<CjMenuVo> getPermByName(String userName){
        CjUserDTO cjUserDTO=new CjUserDTO();
        cjUserDTO.setUsername(userName);
        return cjUserMapper.getPerms(cjUserDTO);
    }
}

