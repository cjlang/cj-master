package com.cj.core.filter;
import com.cj.cache.common.CJCache;
import com.cj.common.code.GlobalConst;
import com.cj.core.log.CjLog;
import com.cj.core.utils.TokenUtils;
import org.apache.shiro.SecurityUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Service
public class CJInterceptor implements HandlerInterceptor {

    @Autowired
    private CJCache cjCache;

    @Autowired
    protected Mapper dozerMapper;

    @Autowired
    CjLog cjLog;

    public static String OPTIONS = "OPTIONS";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.addHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Credentials ", "true");
        response.addHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Headers", "X-Custom-Header,Origin, X-Requested-With, Content-Type, Accept, Authorization");
        String token = request.getHeader(TokenUtils.tokenHeard);
        String sid = request.getHeader(TokenUtils.Sid);
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if (OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return false;
        }
        if (null == token || "".equals(token)) {
            return false;
        }
        //验证token的真实性
        try {
            if(cjCache.get(TokenUtils.getTokenBody(token).getSubject()+":"+sid)==null)
            {
                ReturnMsg(response);
                return false;
            }
        } catch (Exception e) {
            ReturnMsg(response);
            return false;
        }
        cjLog.log(SecurityUtils.getSubject().getSession()+"CJInterceptor~~~~~~~~~~~~~~~~~放过");
        return  true;
    }

    public void ReturnMsg(HttpServletResponse response) throws IOException {
        cjLog.log(SecurityUtils.getSubject().getSession()+"CJInterceptor~~~~~~~~~~~~~~~~~拦截");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write("{\"code\":\"-9\",\"msg\":\"(HandlerInterceptor)token认证失效！\"}");
    }
}