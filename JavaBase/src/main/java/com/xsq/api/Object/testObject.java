package com.xsq.api.Object;

public class testObject {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 21);
        Student s2 = new Student("zhangsan", 21);

        System.out.println(s1 == s2);//==:比较引用的地址值
        System.out.println(s1.equals(s2));//比较对象是否相等，默认比较地址，重写可以比较内容;底层也是==
    }
}
