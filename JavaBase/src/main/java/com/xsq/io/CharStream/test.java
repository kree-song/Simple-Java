package com.xsq.io.CharStream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * 将用户名和密码录入到文件中
 * */
public class test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("name:");
        String name = sc.next();
        System.out.println("pwd:");
        String pwd = sc.next();

        FileWriter fw = new FileWriter("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt");
        fw.write(name + "\n");
        fw.write(pwd);
        fw.close();

    }
}
