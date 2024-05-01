package com.xsq.collections.collection.HashSet;

/*
 * 默认的hashCode是根据对象来产生，重写后会根据对象里的值来产生
 * */
public class testHashSet {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);

        System.out.println(s1.hashCode());//356573597
        System.out.println(s1.hashCode());//356573597
        System.out.println(s2.hashCode());//1735600054
    }
}
