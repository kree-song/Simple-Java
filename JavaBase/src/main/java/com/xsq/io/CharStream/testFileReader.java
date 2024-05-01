package com.xsq.io.CharStream;

import java.io.FileReader;
import java.io.IOException;

/*
 * 读取字符的两种形式
 * */
public class testFileReader {
    public static void main(String[] args) throws IOException {
        //method1();
        //method2();
    }

    private static void method2() throws IOException {
        //一次读取多个字符
        FileReader fr = new FileReader("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt");
        //读取数据
        char[] chars = new char[1024];
        int len;
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        //关闭资源
        fr.close();
    }

    private static void method1() throws IOException {
        //一次读取一个字符
        //创建字符输入流对象
        FileReader fr = new FileReader("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt");
        //读取数据
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        //关闭资源
        fr.close();
    }
}
