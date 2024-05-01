package com.xsq.io.file;

import java.io.File;

/*
 * 需求：删除一个多级文件夹
 * delete方法只能删除文件和空文件夹，如果要删除一个有内容的文件夹,需要先删掉这个文件夹里面的所有的内容，最后再删除这个文件夹
 * */
public class testFileDelete02 {
    public static void main(String[] args) {
        File src = new File("C:\\Ua\\apple\\Desktop\\src");
        deleteDir(src);
    }

    private static void deleteDir(File src) {
        //先删掉这个文件夹里面的所有内容
        //递归：方法在方法体中自己调用自己
        //注意：可以解决所有文件夹和递归相结合的题目
        //1.进入---得到src文件夹里面所有内容的File对象
        File[] files = src.listFiles();
        //2.遍历---得到src文件夹里面的每一个文件和文件夹的File对象
        for (File file : files) {
            if (file.isFile()) {
                //3.判断---如果遍历得到的File对象是一个文件，那么直接删除
                file.delete();
            } else {
                //4.判断
                //递归
                deleteDir(file);//参数一定要是src文件夹里面的文件夹File对象
            }
        }
        //最后再删除这个文件夹
        src.delete();
    }
}
