package com.xsq.leetcode.simplebook.String;

/*
 * 整数翻转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围，就返回 0。
 * */
public class String_02IntReverse {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        long res = 0;
        int op = x > 0 ? 1 : -1;
        int p = Math.abs(x);
        int q = 0;
        while (p != 0) {
            q = p % 10;
            p = p / 10;
            res = res * 10 + q;
        }
        //最后讨论是否超过 32 位的有符号整数的范围
        return op * (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE ? 0 : (int) res);

    }

}
