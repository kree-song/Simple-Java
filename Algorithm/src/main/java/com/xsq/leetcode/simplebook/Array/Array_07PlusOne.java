package com.xsq.leetcode.simplebook.Array;

import java.util.Arrays;

/*
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
 * */
public class Array_07PlusOne {
    public static void main(String[] args) {
        int[] arr = {9, 9};//{9}->{1,0} {9,9}->{1,0,0}
        Array_07PlusOne po = new Array_07PlusOne();
        System.out.println(Arrays.toString(po.plusOne(arr)));
    }

    //指针法
    public int[] plusOne(int[] digits) {
        int right = digits.length - 1;
        while (right > -1) {
            if (digits[right] < 9) {
                digits[right] += 1;
                return digits;
            } else if (digits[right] == 9 && right != 0) {
                digits[right] = 0;
                --right;
            } else if (digits[0] == 9) {
                digits[0] = 0;
                int[] newArr = new int[digits.length + 1];
                System.arraycopy(digits, 0, newArr, 1, digits.length);
                newArr[0] = 1;
                digits = newArr;
                return digits;
            }
        }
        return digits;
    }

    //模拟进位
    public int[] plusOne02(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;//0~9/10
            //若最后一个数字为0~8，则直接+1返回
            if (digits[i] != 0) return digits;
        }
        //若为连续的9，则创建一个新数组
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
