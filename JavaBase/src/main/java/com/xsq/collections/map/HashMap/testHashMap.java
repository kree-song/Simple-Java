package com.xsq.collections.map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testHashMap {
    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap<>();

        Student s1 = new Student("zhangsan", 21);
        Student s2 = new Student("lisi", 22);
        Student s3 = new Student("wangwu", 20);

        hm.put(s1, "北京");
        hm.put(s2, "南京");
        hm.put(s3, "武汉");

        //第一种：先获取到所有的键，再通过每一个键来找到对应的值
        Set<Student> students = hm.keySet();
        for (Student student : students) {
            String value = hm.get(student);
            System.out.println(student + "---" + value);
        }
        System.out.println("----------------------------------------------");

        //第二种：先获取到所有的键值对对象，再获取到里面的每一个键和每一个值
        Set<Map.Entry<Student, String>> entries = hm.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);
        }
        System.out.println("-------------------------------------------------");

        //第三种：foreach
        hm.forEach((Student key, String value) -> {
            System.out.println(key + "---" + value);
        });
    }
}
