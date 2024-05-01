package com.xsq.api.Integer;

public class testInteger {
    public static void main(String[] args) {
        Integer i1 = new Integer(100);
        Integer i2 = new Integer("100");
        Integer i3 = Integer.valueOf(200);
        Integer i4 = Integer.valueOf("200");
        System.out.println(i1 + "\t" + i2 + "\t" + i3 + "\t" + i4);

        Integer i5 = 200;//自动装箱
        if (i5 != null) {
            i5 += 300;//自动装、拆箱
            System.out.println(i5);
        }
        System.out.println("----------------------------------------------------");

        String i6 = "100";
        int i7 = 200;
        System.out.println(i6 + i7);//字符串+任意的数据类型结果都是一个字符串
        int i8 = Integer.parseInt(i6);
        System.out.println(i7 + i8);
        System.out.println("----------------------------------------------------");

        //int->String
        int i9 = 100;
        String str = i9 + "";
        String str2 = String.valueOf(i9);
        System.out.println(str + "\t" + str.length() + "\t" + str2);

        //String->int
        String s = "1122";
        int a = Integer.parseInt(s);
        int b = Integer.valueOf(s).intValue();
        System.out.println(a + "\t" + b);


    }

}
