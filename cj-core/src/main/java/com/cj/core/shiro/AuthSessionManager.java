package com.cj.core.shiro;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public class AuthSessionManager extends DefaultWebSessionManager {

    public final String TOKEN_NAME = "sid";
    public final static String HEADER_TOKEN_NAME = "sid";
    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";


    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String sessionId = WebUtils.toHttp(request).getHeader(HEADER_TOKEN_NAME);
        if (StringUtils.isEmpty(sessionId)) {
            return super.getSessionId(request, response);
        } else {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sessionId;
        }
    }

    @Override
    protected void onStart(Session session, SessionContext context) {
        if (!WebUtils.isHttp(context)) {
        } else {
            HttpServletRequest request = WebUtils.getHttpRequest(context);
            HttpServletResponse response = WebUtils.getHttpResponse(context);
            Serializable sessionId = session.getId();
            this.storeSessionId(sessionId, request, response);
            request.removeAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_IS_NEW, Boolean.TRUE);
        }
    }


    private void storeSessionId(Serializable currentId, HttpServletRequest ignored, HttpServletResponse response) {
        if (currentId == null) {
            String msg = "session不能空";
            throw new IllegalArgumentException(msg);
        } else {
            String idString = currentId.toString();
            response.setHeader(this.TOKEN_NAME, idString);
        }
    }
}