package com.xsq.languageBase.Features.properties;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
 * properties的增删改查、遍历
 * */
public class testProperties {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //增
        prop.put("a", "1");
        prop.put("b", "2");
        prop.put("c", "3");
        prop.put("d", "4");
        System.out.println(prop);
        //删
        prop.remove("d");
        System.out.println(prop);
        //改
        //put:如果键存在就添加，不存在就覆盖
        prop.put("a", 10);
        System.out.println(prop);
        //查
        Object b = prop.get("b");
        System.out.println(b);

        //遍历
        Set<Object> keys = prop.keySet();
        for (Object key : keys) {
            Object value = prop.get(key);
            System.out.println("key:" + key + "\t" + "value:" + value);
        }
        System.out.println("---------------------------------------------------");

        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key:" + key + "\t" + "value:" + value);
        }
    }
}
