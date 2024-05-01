package com.xsq.io.CharStream;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 字符流写数据
 * void write(int c)：下一个字符

 * void write(char[] cbuf)：写出一个字符数组

 * void write(char[] cbuf,int off,int len)：写出字符数组的一部分

 * void write(String str)：写一个字符串

 * void write(String str,int off,int len)：写一个字符串的一部分
 * */
public class testFileWriter {
    public static void main(String[] args) throws IOException {
        //创建字符输出流对象
        //若文件不存在就创建，但是要保证父级路径存在
        //若文件存在就清空
        FileWriter fw = new FileWriter("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt", true);

        //写出数据
        //写int类型数据，实际写出的是整数在码表上对应的字母
        //写字符串数据，是把字符串本身原样写出
        //fw.write(97);
        char[] chars = {97, 98, 99, 100, 101};
        //fw.write(chars,0,3);
        //fw.write("你好，世界");
        fw.write("你好，世界", 0, 3);

        //关闭资源，每次使用完流必须要释放资源
        fw.close();
    }
}
