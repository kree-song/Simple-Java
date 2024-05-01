package com.xsq.collections.map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testMap02 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1号丈夫", "1号妻子");
        map.put("2号丈夫", "2号妻子");
        map.put("3号丈夫", "3号妻子");
        map.put("4号丈夫", "4号妻子");
        map.put("5号丈夫", "5号妻子");

        //bianli01(map);

        //首先获取所有的键值对对象
        //Set集合中装的是键值对对象(Entry对象)
        //Entry装的是键和值
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);
        }
    }

    private static void bianli01(Map<String, String> map) {
        //获取所有的键
        Set<String> keys = map.keySet();
        for (String key : keys) {
            //根据键来获取对应的值
            String value = map.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
