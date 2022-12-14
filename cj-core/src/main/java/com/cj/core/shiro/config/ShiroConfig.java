package com.cj.core.shiro.config;

import com.cj.core.shiro.AuthFilter;
import com.cj.core.shiro.AuthRealm;
import com.cj.core.shiro.AuthSessionManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Value("${cj.filter.excludePathPatterns}")
    private List<String> cjfilter;

    @Autowired
    private AuthRealm authRealm;

    @Bean("defaultWebSessionManager")
    public DefaultWebSessionManager defaultWebSessionManager(){
        AuthSessionManager sessionManager = new AuthSessionManager();
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }

    @Bean(name="securityManager")
    public DefaultWebSecurityManager myDefaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        securityManager.setSessionManager(defaultWebSessionManager());
        return securityManager;
    }

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // ?????? SecurityManager
        bean.setSecurityManager(defaultWebSecurityManager);

        Map<String, Filter> filterMap = new HashMap<>(16);
        bean.setFilters(filterMap);
        filterMap.put("cjAuth",new AuthFilter());//?????????new?????????????????????

        // ????????????????????????Url
        bean.setSuccessUrl("/sys/success");
        // ??????????????????Url
        bean.setLoginUrl("/sys/login");
        // ?????????????????????Url
        bean.setUnauthorizedUrl("/sys/unauth");
        /**
         * anon????????????????????????
         * authc????????????????????????
         * user?????????rememberMe?????????
         * perms????????????????????????
         * role??????????????????????????????
         **/
        Map<String, String> authMap = new LinkedHashMap<>();
        authMap.put("/","anon");
        authMap.put("/doc.html","anon");
        authMap.put("/sys/login","anon");
        authMap.put("/webjars/**","anon");
        authMap.put("/unlogin","anon");
        authMap.put("/sys/success","anon");
        authMap.put("/sys/unauth","anon");
        authMap.put("/swagger-resources/**","anon");
        authMap.put("/v2/**","anon");

        for (int i = 0; i <cjfilter.size() ; i++) {
            authMap.put(cjfilter.get(i),"anon");
        }
        authMap.put("/**","cjAuth");
        bean.setFilterChainDefinitionMap(authMap);
        return bean;
    }

    /**
     * ??????OPTION????????????
     * @return
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.setMaxAge(15000L);
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        // ???????????????????????????
        bean.setOrder(-1);

        return bean;
    }

    /**
     * ??????shiro??????????????????controller??????????????????
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
