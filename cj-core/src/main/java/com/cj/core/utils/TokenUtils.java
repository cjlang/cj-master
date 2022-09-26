package com.cj.core.utils;
import io.jsonwebtoken.*;
import org.apache.shiro.SecurityUtils;

import java.util.Date;

public class TokenUtils {

    private static final String secret = "!@#123qwecjlang";
    public static final String tokenHeard = "token";
    public static final String Sid = "sid";
    private static final Long expTime = 1800 * 1000L;

    /**
     * 生成token
     * @param name
     * @param id
     * @param ip
     * @return
     */
    public static String getToken(String name,String id,String ip) {
        JwtBuilder builder = Jwts.builder();
        builder.signWith(SignatureAlgorithm.HS256,secret);
        builder.setId(id).setSubject(name).setAudience(ip);
        builder.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expTime));
        String token = builder.compact();
        return token;
    }

    /**
     * 获取当前登录对象
     * @param token
     * @return
     */
    public static Claims getTokenBody(String token) {
        JwtParser parser = Jwts.parser();
        Claims body = parser.setSigningKey(secret).parseClaimsJws(token).getBody();
        return body;
    }

    /**
     *
     * @param token
     * @return
     */
    public static String getId(String token) {
        Claims body = getTokenBody(token);
        return body.getId();
    }

    public static String getUserName(){
       return SecurityUtils.getSubject().getPrincipal().toString();
    }
}

