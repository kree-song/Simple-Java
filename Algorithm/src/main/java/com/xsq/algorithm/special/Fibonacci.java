package com.xsq.algorithm.special;

/*
 * 斐波那契数列求解
 * */
public class Fibonacci {
    //动态规划-----有问题
    public static int[] arr = new int[1000];

    public static void main(String[] args) {
        System.out.println(Fib2(3));
    }

    //分治法
    public static int Fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fib(n - 1) + Fib(n - 2);//有重复计算
        }
    }

    public static int Fib2(int n) {
        int result = arr[n];//若计算过则直接使用
        if (result == 0) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            } else {
                return Fib2(n - 1) + Fib2(n - 2);//有重复计算
            }
        }
        arr[n] = result;
        return result;
    }
}
