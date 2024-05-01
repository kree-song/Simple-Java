package com.xsq.collections.map.TreeMap;

import java.util.Comparator;
import java.util.TreeMap;

/*
 * 按年龄进行排序
 * */
public class testTreeMap {
    public static void main(String[] args) {
        TreeMap<Student, String> tm = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按年龄进行排序
                int result = o1.getAge() - o2.getAge();
                //次要条件，按姓名排序
                result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                return result;
            }
        });

        Student s1 = new Student("zhangsan", 21);
        Student s2 = new Student("lisi", 22);
        Student s3 = new Student("wangwu", 20);

        tm.put(s1, "北京");
        tm.put(s2, "南京");
        tm.put(s3, "武汉");

        tm.forEach((Student key, String value) -> {
            System.out.println(key + "---" + value);
        });
    }
}
