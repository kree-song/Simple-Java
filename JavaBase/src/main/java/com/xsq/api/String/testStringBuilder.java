package com.xsq.api.String;

/*
 * StringBuilder是一个可变的字符串类，可以把它看作为一个容器
 * 作用：提高字符串的操作效率
 * 构造方法：public StringBuilder():创建一个空白可变的字符串对象，不含有任何内容
 *         public StringBuilder(String str):根据字符串内容来创建可变字符串对象
 * StringBuilder与String(两者可互换)的区别：
 *         String：内容不可改变
 *         StringBuilder：内容可改变
 * */
public class testStringBuilder {
    public static void main(String[] args) {
//构造方法
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder("abc");
        System.out.println(sb2);
        System.out.println(sb2.length());

//成员方法
        //添加任意类型数据，并返回对象本身(可用于字符串拼接 )
        StringBuilder sb3 = new StringBuilder();
        sb3.append(123);
        sb3.append("abc");
        sb3.append(true);
        System.out.println(sb3);
        //链式编程：如果一个方法返回的是对象类型，对象就可以继续向下调用方法
        StringBuilder sb4 = new StringBuilder();
        sb4.append("红色").append("蓝色").append("紫色");
        System.out.println(sb4);

        //返回相反的字符序列
        System.out.println("反转前：" + sb4);
        sb4.reverse();
        System.out.println("反转后：" + sb4);

        //返回长度(字符出现的个数)
        System.out.println("sb4中字符的个数为" + sb4.length());

        //通过toString()可以实现把StringBuilder转换为String
        String s = sb4.toString();
        System.out.println(s);

        System.currentTimeMillis();//获取自1970年1月1日0时0分0秒 到当前时间的所经历过的毫秒值

    }
}
