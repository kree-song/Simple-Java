package com.xsq.collections.collection.HashSet;

import java.util.HashSet;

/*
 * 要求：若学生对象的成员变量值相同，就认为是同一个对象(默认的hashCode是根据对象来产生)
 *
 * 结论：如果HashSet集合要存储自定义对象，那么必须重写hashCode(使s1、s2在同一个位置)和equals(如果值相同就舍弃)方法
 * */
public class testHashSet02 {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("zhangsan", 23);
        Student s3 = new Student("lisi", 21);

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);

        for (Student h : hs) {
            System.out.println(h);
        }
    }
}
