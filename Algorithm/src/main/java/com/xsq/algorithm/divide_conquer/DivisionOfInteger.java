package com.xsq.algorithm.divide_conquer;

import java.util.Scanner;

/*
 * 整数划分：正整数n表示成一系列正整数之和; 求正整数n 的不同划分个数p
 * n=1,m=1 q(1,1)=1
 * n<m,q(n,m)=q(n,n)
 * n=m,q(n,m)=1+q(n,n-1)
 * n>m,q(n,m)=q(n-m,m)+q(n,m-1)
 * */
public class DivisionOfInteger {
    static int[] a = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {//hasnextInt可以先帮系统判定是不是整数,是整数就可以赋值。如果不是(String或者double) 就不会赋值。
            int n = sc.nextInt();
            int count = q(n, n, 0);
            System.out.println(count);
        }
    }

    //核心
    public static int q(int n, int m, int i) {//q(n,m)表示整数 n 的划分中，每个数不大于 m 的划分数
        if (n < m) {
            return q(n, n, i);
        }
        a[i] = m;
        if (n == 0 || m == 0) {
            printPartition(i);
            return 0;
        }
        if (n == 1 || m == 1) {
            if (n == 1) {
                printPartition(i);
            } else q(n - 1, 1, i + 1);
            return 1;
        }
        if (n == m) {
            printPartition(i);
            return 1 + q(n, n - 1, i);
        }
        return q(n - m, m, i + 1) + q(n, m - 1, i);//顺序错位则全错
    }

    public static void printPartition(int i) {
        System.out.print("{");
        for (int j = 0; j <= i; j++) {
            if (j == i) {
                System.out.print(a[j]);
            } else {
                System.out.print(a[j] + "+");
            }
        }
        System.out.println("}");
    }
}
