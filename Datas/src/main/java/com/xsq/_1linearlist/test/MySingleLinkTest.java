package com.xsq._1linearlist.test;

import com.xsq._1linearlist.MySingleLink;

public class MySingleLinkTest {
    public static void main(String[] args) {
        MySingleLink link = new MySingleLink();

        System.out.println(link.isEmpty());
        System.out.println(link.getSize());

        //插入元素
        link.insert(0, "aa");
        link.insert(0, "bb");
        link.insert(0, "cc");
        link.insert(0, "dd");

        System.out.println(link);
        //判断元素是否存在
        System.out.println(link.indexOf("dd"));
        System.out.println(link.indexOf("xx"));
        System.out.println(link.contains("cc"));

        //删除结点
        System.out.println(link.remove("xx"));
        System.out.println(link.remove("bb"));
        System.out.println(link);
        System.out.println(link.remove(0));
        System.out.println(link);

        System.out.println(link.get(0));
        System.out.println(link.replace(0, "CC"));
        System.out.println(link);

        link.insertBefore("aa", "bb");
        link.insertafter("bb", "BB");
        System.out.println(link);
    }
}
