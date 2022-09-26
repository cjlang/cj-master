package com.cj.core.aspect;

import com.cj.cache.common.CJCache;
import com.cj.common.vo.J;
import com.cj.core.annotation.Authority;
import com.cj.core.auto.entity.CjUserEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import static com.cj.common.code.GlobalConst.Token_Name;

@Component
@Aspect
public class AuthorityAspect {

    @Autowired
    private CJCache cjCache;

    @Pointcut("@annotation(com.cj.core.annotation.Authority)")
    public void AuthrityAround(){}

    @Around("AuthrityAround() && @annotation(authority)")
    public Object doAround(ProceedingJoinPoint joinPoint, Authority authority) throws Throwable{
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String token = request.getHeader(Token_Name);
        if(token!=null)
        {
            CjUserEntity userEntity=(CjUserEntity)cjCache.get(token);
            List<String> list=(List<String>)cjCache.get("PERMISSION:"+token);
            if(list.contains(authority.value()))
            {
                return joinPoint.proceed();
            }
            return J.error("没有权限");
        }
        return J.error("未登陆");
    }
}
