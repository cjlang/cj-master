package com.cj.dc;

import net.openhft.compiler.CompilerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class WebAppConfig {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;

    //初始化变量
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws Exception {
        String className = "comcjdc.LoginController2";
        String javaCode = "package comcjdc;\n" +
                "\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "import javax.servlet.http.HttpServletRequest;\n" +
                "\n" +
                "@RestController\n" +
                "@RequestMapping(\"/login\")\n" +
                "public class LoginController2 {\n" +
                "\n" +
                "    @GetMapping(\"/test2\")\n" +
                "    public String Logout(HttpServletRequest request) {\n" +
                "        return \"hello laolang\";\n" +
                "    }\n" +
                "\n" +
                "}";
        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
        Object o=aClass.newInstance();
        //将new出的对象放入Spring容器中
        defaultListableBeanFactory.registerSingleton("userDao",o);
        //自动注入依赖
        beanFactory.autowireBean(o);
    }
}
