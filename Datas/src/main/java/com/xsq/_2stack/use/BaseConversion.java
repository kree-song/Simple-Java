package com.xsq._2stack.use;

import com.xsq._2stack.MyArrayStack;

/*
 * 使用栈完成进制转换
 * */
public class BaseConversion {
    public static void main(String[] args) {
        System.out.println(convert(100, 2));
    }

    //将一个十进制数num转换为decimal指定的进制
    public static String convert(int num, int decimal) {
        MyArrayStack stack = new MyArrayStack();
        int remainder = num % decimal;//余数
        while (num != 0) {
            stack.push(remainder);//余数压栈
            num = num / decimal;//商
            remainder = num % decimal;
        }
        //出栈，余数倒序
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
