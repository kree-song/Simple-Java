package com.xsq.other;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * \\d: digital匹配数字; \\表示双重转义，第一个转\，第二个转字母
 * \\w: word匹配字符，包括数字、字母、下划线; \W:匹配\w不能匹配的字符，大写表示取反
 * \\s: space匹配空格(\t、 、\n ); \S:匹配\s不能匹配的字符
 * {m,n}、{m}: 表示数量范围，n不写表示无穷
 * .: 占位符，可匹配任意字符
 * *: 匹配任意次
 * +: 至少匹配一次，等价于{1,}
 * ?: 匹配0或1次，等价于{0,1};标记为非贪婪匹配
 * [0189]: 单个字符的范围;[1-9a-gU-Z]
 * |: 选择其中一个
 * ^: [^1-3]表示该字符不能是1-3
 * (): 用()将要取值的地方括起来，传给Pattern对象，再用Pattern对象匹配后获得的Matcher对象取值，匹配的值按照顺序存放在Matcher对象的group中
 * */
public class RegexTest {
    public static void main(String[] args) {
        // \\d,\\w,\\s
        System.out.println("abc".matches("abc"));//精准匹配，用String.equals()即可
        System.out.println("a".matches("\\w{1,2}"));//表示匹配1-2个字母
        System.out.println("Leet\tCode 666".matches("\\w{4}\\s\\w{4}\\s\\d{3}"));
        // . * + ?
        System.out.println("a%c".matches("a.c"));
        System.out.println("".matches("\\w*"));
        System.out.println("ab".matches("\\w+"));
        System.out.println("a".matches("\\w?"));
        // [] | [^]
        System.out.println("a".matches("[1-9a-gU-Z]"));
        System.out.println("abc".matches("abc|ABC"));
        System.out.println("1".matches("[^1-3]"));

        //从字符串中取出指定值,String.matches()底层实现
        Pattern pattern = Pattern.compile("Name:(\\w+)\\s*Age:(\\d{1,3})");
        Matcher matcher = pattern.matcher("Name:Aurora Age:18");
        if (matcher.matches()) {//匹配成功返回true
            String group1 = matcher.group(1);//group(0)用来保存整个字符串
            String group2 = matcher.group(2);
            System.out.println(group1);
            System.out.println(group2);
            System.out.println(matcher.group(0));
        }
        //每次调用String.matches()都会新建一个Pattern对象。故若要用同一个正则表达式多次匹配字符串的话，
        //最佳做法是先用正则表达式创建一个Pattern对象，然后反复调用
        Pattern pattern2 = Pattern.compile("Name:(\\w+)\\s*Age:(\\d{1,3})");
        boolean matches1 = pattern.matcher("Name:Aurora Age:18").matches();
        boolean matches2 = pattern.matcher("Name:Bob    Age:20").matches();
        boolean matches3 = pattern.matcher("Name:Cassin Age:22").matches();

        //替换String.spilt()的精准匹配，改为模糊匹配
        System.out.println(Arrays.toString("二分;查找;递归;分治".split("[,;\\s]+")));
        //替换String.replaceAll()的精准匹配，改为模糊匹配
        System.out.println("二分;查找;递归;分治".replaceAll("[,;\\s]+", "/"));
        //反向引用匹配到的字符串，用()即可;用于某一部分添加前后缀
        System.out.println("二分;查找;递归;分治".replaceAll("([,;\\s]+)", "--$1--"));

        //贪婪匹配、非贪婪匹配(在需要非贪婪匹配的正则表达式上加?)
        //Pattern pattern3 = Pattern.compile("(\\w+)(e*)");//贪婪匹配:尽可能多的向后匹配
        Pattern pattern3 = Pattern.compile("(\\w+?)(e*)");//非贪婪匹配:尽可能少的向后匹配
        Matcher matcher3 = pattern3.matcher("LeetCode");
        if (matcher3.matches()) {
            String group1 = matcher3.group(1);
            String group2 = matcher3.group(2);
            System.out.println("group1=" + group1 + ",length=" + group1.length());
            System.out.println("group1=" + group2 + ",length=" + group2.length());
        }
    }
}
