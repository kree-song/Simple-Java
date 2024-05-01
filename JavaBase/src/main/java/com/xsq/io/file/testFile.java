package com.xsq.io.file;

import java.io.File;
import java.io.IOException;

//相对路径、绝对路径
public class testFile {
    public static void main(String[] args) throws IOException {
        //绝对路径
        File file = new File("E:\\常用文件\\A java学习\\AAA\\notes\\abcsdf\\abc");
        //System.out.println(file.delete());

        //当前项目下的a.txt
        File file2 = new File("a.txt");
        File file3 = new File("JavaBase\\a.txt");
        //file3.createNewFile();

        //当前项目下指定模块下的a.txt

        File file4 = new File("JavaBase");
        System.out.println(file4.getAbsolutePath());
        System.out.println(file4.getPath());
        File[] files = file4.listFiles();
        for (File file5 : files) {
            System.out.println(file5);
        }


    }
}
