package com.cj.core.shiro;//package com.cj.auth.shiro;
//
//import com.cj.cache.common.CJCache;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.UnknownSessionException;
//import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.Serializable;
//import java.util.Collection;
//
///**
// * 不需要将session缓存到redis
// */
//@Service
//public class AuthSessionDao extends AbstractSessionDAO {
//
//    public static final int EXPIRE_TIME = 5000;
//
//    @Autowired
//    private CJCache cjCache;
//
//    @Override
//    protected Serializable doCreate(Session session) {
//        Serializable sessionId = this.generateSessionId(session);
//        this.assignSessionId(session, sessionId);
//        cjCache.put(sessionId.toString(),session,EXPIRE_TIME);
//        return sessionId;
//    }
//
//    @Override
//    public void update(Session session) throws UnknownSessionException {
//        cjCache.put(session.getId().toString(),session,EXPIRE_TIME);
//    }
//
//    @Override
//    public void delete(Session session) {
//        cjCache.del(session.getId().toString());
//    }
//
//    @Override
//    protected Session doReadSession(Serializable sessionId) {
//        Session session=(Session)cjCache.get(sessionId.toString());
//        return session;
//    }
//
//    @Override
//    public Collection<Session> getActiveSessions() {
//        return null;
//    }
//}
