package com.xsq.io.ConvertedStream;

import java.io.*;

/*
 * 通过转换流解决文件乱码
 * InputStreamReader：字节流转字符流
 * OutputStreamWriter：字符流转字节流
 * */
public class testConvertedStream {
    public static void main(String[] args) throws IOException {
        //method1();
        //method2();
        //method3();
    }

    private static void method3() throws IOException {
        //JDK11之后，字符流新推出了一个构造，也可以指定编码表
        /*FileReader fr=new FileReader("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt", Charset.forName("gbk"));
        int ch;
        while ((ch=fr.read())!=-1){
            System.out.print((char)ch);
        }
        fr.close();*/
    }

    private static void method2() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("JavaBase\\src\\com\\xsq\\io\\a.txt"), "gbk");
        int ch;
        while ((ch = isr.read()) != -1) {
            System.out.print((char) ch);
        }
        isr.close();

        //转换流是字符流的父类，字符流的方法对应转换流都可以用
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("JavaBase\\src\\com\\xsq\\io\\a.txt"), "UTF-8");
        osw.write("我爱学习");
        osw.close();
    }

    private static void method1() throws IOException {
        //这个方法直接读取电脑文件会产生乱码
        //文件是GBK码表，而idea默认是UTF-8编码格式，两者不一致导致乱码
        FileReader fr = new FileReader("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt");
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();
    }
}
