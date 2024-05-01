package com.xsq.linearlist.test;

import com.xsq.linearlist.MyArrayList;

// 测试MyArrayList
public class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList List1 = new MyArrayList();
        // 1.判断是否为空
        System.out.println(List1.isEmpty());
        System.out.println(List1.getSize());
        // 2.添加元素
        List1.insert(0, "aa");
        List1.insert(1, "bb");
        List1.insert(0, "cc");
        System.out.println(List1.isEmpty());
        System.out.println(List1.getSize());
        // 3.把线性表中的内容打出
        System.out.println(List1);//[cc,aa,bb]
        // 4.判断是否存在
        System.out.println(List1.indexOf("cc"));
        System.out.println(List1.indexOf("bb"));
        System.out.println(List1.indexOf("dd"));
        System.out.println(List1.contains("aa"));
        System.out.println(List1.contains("xx"));
        // 5.删除
        List1.remove("dd");
        System.out.println(List1);//[cc,aa,bb]删除不存在的元素
        List1.remove("bb");
        System.out.println(List1);//[cc,aa]
        List1.remove(0);
        System.out.println(List1);//[aa]
        // 6.替换
        List1.insert(0, "xx");
        List1.insert(0, "oo");
        List1.insert(0, "yy");
        System.out.println(List1);//[yy,oo,xx,aa]
        List1.replace(0, "YY");
        System.out.println(List1);//[YY,oo,xx,aa]
        // 7.返回指定索引值的元素
        System.out.println(List1.get(0));
        System.out.println(List1.get(1));
        System.out.println(List1.get(3));
        // 8.在指定元素前面/后面插入另外的元素
        List1.insertBefore("oo", "JJ");
        System.out.println(List1);//[YY,JJ,oo,xx,aa]
        List1.insertafter("oo", "jj");
        System.out.println(List1);//[YY,JJ,oo,jj,xx,aa]
        List1.insertafter("TT", "BB");
        System.out.println(List1);//[YY,JJ,oo,jj,xx,aa]
    }

}
