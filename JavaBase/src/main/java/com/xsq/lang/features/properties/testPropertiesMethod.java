package com.xsq.lang.features.properties;

import java.util.Properties;
import java.util.Set;

/*
 * Properties作为集合的特有方法:
 * Object setProperty(String key,String value)：设置集合的键和值，都是String类型，底层调用Hashtable方法

 * String getProperty(String key)：使用此属性列表中指定的键搜索属性

 * Set<String> stringPropertyNames()：从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串
 * */
public class testPropertiesMethod {
    public static void main(String[] args) {
        //Object setProperty(String key,String value)---put
        Properties prop = new Properties();
        prop.setProperty("江苏", "南京");
        prop.setProperty("湖北", "武汉");
        prop.setProperty("山东", "济南");
        System.out.println(prop);

        //String getProperty(String key)---get
        String value = prop.getProperty("江苏");
        System.out.println(value);

        //Set<String> stringPropertyNames()---keySet
        Set<String> keys = prop.stringPropertyNames();
        for (String key : keys) {
            String value1 = prop.getProperty(key);
            System.out.println(key + "=" + value1);
        }


    }
}
