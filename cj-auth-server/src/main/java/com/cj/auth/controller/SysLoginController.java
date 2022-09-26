package com.cj.auth.controller;

import com.cj.cache.common.CJCache;
import com.cj.common.vo.J;
import com.cj.core.auto.dto.CjUserDTO;
import com.cj.core.auto.vo.CjMenuVo;
import com.cj.core.auto.vo.CjRoleVo;
import com.cj.core.manual.bllservice.CjUserBllService;
import com.cj.core.utils.DozerUtils;
import com.cj.core.utils.TokenUtils;
import com.cj.core.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Api(value = "登录", tags = {"[登录认证接口]"})
@RequestMapping("/sys")
public class SysLoginController {

    @Autowired
    private CJCache cjCache;
    @Autowired
    CjUserBllService cjUserBllService;

    @GetMapping("/logout")
    @ApiOperation(value = "登出系统", notes = "删除服务器上的token信息")
    public J Logout() {
        Subject subject=SecurityUtils.getSubject();
        cjCache.del(subject.getSession().getId()+"");
        subject.logout();
        return J.ok();
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录系统", notes = "登录后的token，放在密码里面的")
    public J Login(HttpServletRequest request, @ApiParam(value = "传入json格式", required = true) @RequestBody CjUserDTO dto) throws Exception {
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getUsername(), dto.getPassword());
        Subject subject=SecurityUtils.getSubject();
        subject.login(token);
        String jwttoken = TokenUtils.getToken(dto.getUsername(), subject.getSession().getId()+"", request.getRemoteAddr());
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("token",jwttoken);
        map.put("sid",subject.getSession().getId()+"");

        UserInfoVo userInfoVo= DozerUtils.map(cjUserBllService.getUserByName(dto.getUsername()),UserInfoVo.class);
        userInfoVo.setPassword("");

        List<CjRoleVo> roleList=cjUserBllService.getRolesByName(dto.getUsername());
        Set<String> roles=new HashSet<String>();
        for (int i = 0; i <roleList.size() ; i++) {
            roles.add(roleList.get(i).getCode());
        }
        userInfoVo.setRoles(roles);

        List<CjMenuVo> permList=cjUserBllService.getPermByName(dto.getUsername());
        Set<String> perms=new HashSet<String>();
        for (int i = 0; i <permList.size() ; i++) {
            perms.add(permList.get(i).getMenuCode());
        }
        userInfoVo.setPerms(perms);
        map.put("userinfo",userInfoVo);
        cjCache.put(dto.getUsername()+":"+subject.getSession().getId(),userInfoVo,1800000);
        return J.ok(map);
    }

    @GetMapping("/unlogin")
    public J UnLogin(){
        return J.error("未登录");
    }
    @GetMapping("/unauth")
    public J UnAuth(){
        return J.error("未授权");
    }
    @GetMapping("/success")
    public J Success(){
        return J.ok();
    }


//    @RequiresPermissions("myperm")
//    @RequiresRoles("mycode")
}
