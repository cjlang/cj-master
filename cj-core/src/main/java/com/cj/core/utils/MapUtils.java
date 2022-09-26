package com.cj.core.utils;
import io.micrometer.core.instrument.util.StringUtils;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Map工具类
 */
public class MapUtils extends LinkedHashMap<String, Object> {

    public MapUtils() {
    }

    public MapUtils(Map<String, Object> map) {
        this.putAll(map);
    }

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    private boolean isNull(String key) {
        return get(key) == null;
    }

    /**
     * 获取字符串
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return get(key) == null ? null : get(key).toString();
    }

    public String getString(String key, String defaultValue) {
        String val = getString(key);
        return StringUtils.isBlank(val) ? defaultValue : val;
    }

    public Integer getInteger(String key) {
        String value = getString(key);
        if (StringUtils.isNotBlank(value)) {
            return Integer.parseInt(value);
        }
        return null;
    }

    public Integer getInteger(String key, Integer defaultValue) {
        Integer val = getInteger(key);
        return val == null ? defaultValue : val;
    }

    public Long getLong(String key) {
        String value = getString(key);
        if (StringUtils.isNotBlank(value)) {
            return Long.parseLong(value);
        }
        return null;
    }

    public Long getLong(String key, Long defaultValue) {
        Long val = getLong(key);
        return val == null ? defaultValue : val;
    }


    /**
     * 获取map实例
     * 创建一个新的map
     *
     * @return
     */
    public static MapUtils getInstance() {
        return new MapUtils();
    }

    public static MapUtils getInstance(Map<String, Object> map) {
        return new MapUtils(map);
    }

    public static <T> T mapToBean(Map<String, Object> map, Class<?> clazz) throws Exception {
        Object obj = clazz.newInstance();
        if (map != null && !map.isEmpty() && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String propertyName = entry.getKey(); 	// 属性名
                Object value = entry.getValue();		// 属性值
                String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                Field field = getClassField(clazz, propertyName);	//获取和map的key匹配的属性名称
                if (field == null){
                    continue;
                }
                Class<?> fieldTypeClass = field.getType();
                value = convertValType(value, fieldTypeClass);
                try {
                    clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) obj;
    }

    private static Field getClassField(Class<?> clazz, String fieldName) {
        if (Object.class.getName().equals(clazz.getName())) {
            return null;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        Class<?> superClass = clazz.getSuperclass();	//如果该类还有父类，将父类对象中的字段也取出
        if (superClass != null) {						//递归获取
            return getClassField(superClass, fieldName);
        }
        return null;
    }

    /**
     * 将map的value值转为实体类中字段类型匹配的方法
     * @param value
     * @param fieldTypeClass
     * @return
     */
    private static Object convertValType(Object value, Class<?> fieldTypeClass) {
        Object retVal = null;

        if (Long.class.getName().equals(fieldTypeClass.getName())
                || long.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Long.parseLong(value.toString());
        } else if (Integer.class.getName().equals(fieldTypeClass.getName())
                || int.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Integer.parseInt(value.toString());
        } else if (Float.class.getName().equals(fieldTypeClass.getName())
                || float.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Float.parseFloat(value.toString());
        } else if (Double.class.getName().equals(fieldTypeClass.getName())
                || double.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Double.parseDouble(value.toString());
        } else {
            retVal = value;
        }
        return retVal;
    }


}
