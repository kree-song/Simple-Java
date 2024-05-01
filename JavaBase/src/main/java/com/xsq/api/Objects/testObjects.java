package com.xsq.api.Objects;

import java.util.Objects;

public class testObjects {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 23);
        String result = Objects.toString(s1);
        System.out.println(result);

        Student s2 = null;
        String result2 = Objects.toString(s2, "默认字符串");
        System.out.println(result2);
        System.out.println("-------------------------------------------------");

        System.out.println(Objects.isNull(s2));
        System.out.println(Objects.nonNull(s2));
    }
}
