package com.xsq.io.CharStream;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 * 通过String 编码、解码
 * */
public class testCode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //method1();
        //method2();
    }

    //解码
    private static void method2() throws UnsupportedEncodingException {
        byte[] bytes1 = {-23, -69, -111, -23, -87, -84, -25, -88, -117, -27, -70, -113, -27, -111, -104};
        byte[] bytes2 = {-70, -38, -62, -19, -77, -52, -48, -14, -44, -79};
        String s1 = new String(bytes1);
        System.out.println(s1);

        String s2 = new String(bytes2, "gbk");
        System.out.println(s2);
    }

    //编码
    private static void method1() throws UnsupportedEncodingException {
        String s = "黑马程序员";
        byte[] bytes1 = s.getBytes();
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = s.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));
    }
}
