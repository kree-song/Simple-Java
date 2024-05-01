package com.xsq.io.file;

import java.io.File;

/*
 * delete(): 1)不走回收站
 *           2）只能删除文件和空文件夹
 *           3）如果要删除一个有内容的文件夹，只能先进去把内容删除完毕，才能再次删除这个文件夹
 * */
public class testFileDelete {
    public static void main(String[] args) {
        //method01();
        File file = new File("C:\\itheima");
        boolean result = file.delete();
        System.out.println(result);

    }

    private static void method01() {
        File file = new File("C:\\itheima\\a.txt");
        boolean result = file.delete();
        System.out.println(result);
    }
}
