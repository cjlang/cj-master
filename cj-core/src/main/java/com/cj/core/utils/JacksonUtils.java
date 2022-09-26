package com.cj.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 工具类,提供jackson的常用使用方法
 */
public class JacksonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    
    private static TypeReference<Map<String, String>> tr = new TypeReference<Map<String, String>>() {};
    
    /**
     * @Description 对象转为json字符串
     * @param obj(该对象的类应提供getter和setter方法)
     * @return
     * @throws JsonProcessingException
     */
    public static String obj2json(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }
    
    /**
     * @Description json字符串转为对象
     * @param jsonStr
     * @param clazz (对象的类型)
     * @return
     * @throws Exception
     */
    public static <T> T json2pojo(String jsonStr,Class<T> clazz) throws Exception {
        return OBJECT_MAPPER.readValue(jsonStr, clazz);
    }
    
    /**
     * @Description json字符串转为map
     * @param jsonStr
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public static Map<String,Object> json2map(String jsonStr) throws Exception {
        return OBJECT_MAPPER.readValue(jsonStr, Map.class);
    }
    
    /**
     * @Description json字符串转为map(Map<String,T>)
     * @param jsonStr(json字符串)
     * @param clazz(map中value的类型)
     * @return
     * @throws Exception
     */
    public static <T> Map<String,T> json2map(String jsonStr,Class<T> clazz) throws Exception {
        Map<String,Map<String,Object>> map = (Map<String,Map<String,Object>>)OBJECT_MAPPER.readValue(jsonStr, new TypeReference<Map<String,T>>(){});
        Map<String,T> result = new HashMap<String, T>();
        for (Entry<String, Map<String,Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }
    
    /**
     * @Description json字符串转为map(Map<String,String>)
     * @param jsonStr
     * @return
     * @throws Exception
     */
    public static Map<String, String> json2Stringmap(String jsonStr) throws Exception{
    	return OBJECT_MAPPER.readValue(jsonStr, tr);
    }
    
    /**
     * @Description map转为pojo类
     * @param map
     * @param clazz(pojo类型,该类应提供getter和setter方法以及没有参数的构造方法)
     * @return
     */
    @SuppressWarnings("rawtypes")
	public static <T> T map2pojo(Map map,Class<T> clazz){
        return OBJECT_MAPPER.convertValue(map, clazz);
    }
    
    /**
     * @Description json字符串转为list
     * @param jsonArrayStr(json字符串)
     * @param clazz(list中元素的类型)
     * @return
     * @throws Exception
     */
    public static <T> List<T> json2list(String jsonArrayStr,Class<T> clazz)throws Exception{
        List<Map<String,Object>> list = (List<Map<String,Object>>)OBJECT_MAPPER.readValue(jsonArrayStr, new TypeReference<List<T>>() {});
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }
    
    /**
     * @Description json字符串转为list
     * @param jsonArrayStr(json字符串)
     * @param listClass(list的实现类一般是ArrayList.class)
     * @param clazz(list中元素的类型)
     * @return
     * @throws Exception
     */
    public static <T, L> List<T> json2list(String jsonArrayStr,Class<L> listClass, Class<T> clazz) throws Exception{
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(listClass, clazz);
        List<T> result = OBJECT_MAPPER.readValue(jsonArrayStr, javaType);
        return result;
    }
    
}