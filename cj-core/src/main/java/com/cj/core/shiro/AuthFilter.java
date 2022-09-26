package com.cj.core.shiro;

import com.cj.common.code.GlobalConst;
import com.cj.config.CjLogConfig;
import com.cj.core.utils.TokenUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter extends AccessControlFilter {

    /**
     * 是否放行
     * @param servletRequest
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse response, Object mappedValue) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(TokenUtils.tokenHeard);
        if (null == token || "".equals(token)) {
            return false;
        }
        try {
            TokenUtils.getTokenBody(token);
        } catch (Exception e) {
            return false;
        }
        CjLogConfig.log(SecurityUtils.getSubject().getSession()+"AuthFilter~~~~~~~~~~~~~~~~~放过");
        return true;
    }


    /**
     * 访问拒绝返回的都是认证失效
     * @param servletRequest
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse response) throws Exception {
        CjLogConfig.log(SecurityUtils.getSubject().getSession()+"AuthFilter~~~~~~~~~~~~~~~~~拦截");
        HttpServletResponse res = (HttpServletResponse) response;
        res.setStatus(HttpServletResponse.SC_OK);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=utf-8");
        res.getWriter().write("{\"code\":\"-9\",\"msg\":\"(AccessControlFilter)token认证失效!\"}");
        return false;
    }
}
