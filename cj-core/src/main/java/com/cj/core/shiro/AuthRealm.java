package com.cj.core.shiro;

import com.cj.cache.common.CJCache;
import com.cj.core.auto.entity.CjUserEntity;
import com.cj.core.auto.vo.CjMenuVo;
import com.cj.core.auto.vo.CjRoleVo;
import com.cj.core.manual.bllservice.CjUserBllService;
import com.cj.core.vo.UserInfoVo;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthRealm extends AuthorizingRealm {

    @Resource
    CjUserBllService cjUserBllService;

    @Autowired
    CJCache cjCache;

    @Autowired
    protected Mapper dozerMapper;
    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        CjUserEntity entity = cjUserBllService.getUserByName(username);
        if(entity == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                entity.getUsername(), //用户名
                entity.getPassword(),
                entity.getRealName()
        );
        return authenticationInfo;
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @SneakyThrows
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Object obj=cjCache.get(username+":"+ SecurityUtils.getSubject().getSession().getId());
        if(obj!=null)
        {
            UserInfoVo userInfoVo=(UserInfoVo)obj;
            authorizationInfo.setRoles(userInfoVo.getRoles());
            authorizationInfo.setStringPermissions(userInfoVo.getPerms());
        }else{
            UserInfoVo userInfoVo=dozerMapper.map(cjUserBllService.getUserByName(username),UserInfoVo.class);
            userInfoVo.setPassword("");

            List<CjRoleVo> roleList=cjUserBllService.getRolesByName(username);
            Set<String> roles=new HashSet<String>();
            for (int i = 0; i <roleList.size() ; i++) {
                roles.add(roleList.get(i).getCode());
            }
            authorizationInfo.setRoles(roles);
            userInfoVo.setRoles(roles);

            List<CjMenuVo> permList=cjUserBllService.getPermByName(username);
            Set<String> perms=new HashSet<String>();
            for (int i = 0; i <permList.size() ; i++) {
                perms.add(permList.get(i).getMenuCode());
            }
            authorizationInfo.setStringPermissions(perms);
            userInfoVo.setPerms(perms);
            cjCache.put(username+":"+ SecurityUtils.getSubject().getSession().getId(),userInfoVo,1800000);
        }
        System.out.println("=====================读取权限===");
        return authorizationInfo;
    }
}
