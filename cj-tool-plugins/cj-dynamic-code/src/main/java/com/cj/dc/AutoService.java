//package com.cj.dc;
//
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ClassUtils;
//import org.springframework.util.ReflectionUtils;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import java.lang.reflect.Method;
//import java.net.URL;
//import java.net.URLClassLoader;
//
//@Component
//// 这里我们需要用到ApplicationContext，但是这个类又不能直接注入，这里就是用这种方法set进来
//public class AutoService implements ApplicationContextAware {
//
//    private RequestMappingHandlerMapping requestMappingHandlerMapping;
//    private ApplicationContext applicationContext;
//
//    public void addMapping() throws Exception {
//        requestMappingHandlerMapping=(RequestMappingHandlerMapping)applicationContext.getBean("requestMappingHandlerMapping");
//        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
//
//        URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL(com.example.dynamicmap.one.MappingService.class.getResource("/") + "1.jar")});
//        Class<?> myController = classLoader.loadClass("com.example.dynamicmap.MyController");
//        // 这里通过builder直接生成了mycontrooler的definition，然后注册进去
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(myController);
//        defaultListableBeanFactory.registerBeanDefinition("myc", beanDefinitionBuilder.getBeanDefinition());
//        Method method=requestMappingHandlerMapping.getClass().getSuperclass().getSuperclass().getDeclaredMethod("detectHandlerMethods",Object.class);
//        method.setAccessible(true);
//        method.invoke(requestMappingHandlerMapping,"myc");
//    }
//
//    public void removeMapping() {
//        requestMappingHandlerMapping=(RequestMappingHandlerMapping)applicationContext.getBean("requestMappingHandlerMapping");
//        Object controller= applicationContext.getBean("myc");
//        if (controller==null) {
//            System.out.println("spring容器中已不存在该实体");
//        }
//        Class<?> targetClass = controller.getClass();
//        ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
//            @Override
//            public void doWith(Method method) {
//                Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
//                try {
//                    Method createMappingMethod = RequestMappingHandlerMapping.class.
//                            getDeclaredMethod("getMappingForMethod", Method.class, Class.class);
//                    createMappingMethod.setAccessible(true);
//                    RequestMappingInfo requestMappingInfo =(RequestMappingInfo)
//                            createMappingMethod.invoke(requestMappingHandlerMapping,specificMethod,targetClass);
//                    if(requestMappingInfo != null) {
//                        requestMappingHandlerMapping.unregisterMapping(requestMappingInfo);
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }, ReflectionUtils.USER_DECLARED_METHODS);
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//}
//
