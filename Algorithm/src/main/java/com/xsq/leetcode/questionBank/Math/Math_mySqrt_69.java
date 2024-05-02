package com.xsq.leetcode.questionBank.Math;

/**
 * 69.x的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 */
public class Math_mySqrt_69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(2147395600));
        System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt(int x) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            long m = i * i;
            long n = (long)(i + 1) * (long)(i + 1);
            if (m == x) {
                return i;
            } else if (m < x && n > x) {
                return i;
            }
        }
        return -1;
    }
}
