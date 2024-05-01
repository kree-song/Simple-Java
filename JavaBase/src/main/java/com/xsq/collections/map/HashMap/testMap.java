package com.xsq.collections.map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class testMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("001", "zhangsan");
        map.put("002", "lisi");
        map.put("003", "wangwu");
        map.put("003", "qianqi");
        map.put("004", "qianqi5");
        System.out.println(map);

        map.remove("004");
        System.out.println(map);

        System.out.println(map.containsKey("003"));
        System.out.println(map.containsValue("abc"));
        System.out.println(map.size());

        map.clear();
        System.out.println(map.isEmpty());
        System.out.println(map);

    }
}
