package com.xsq.algorithm.search;

import java.util.Scanner;

/*
 * 线性搜索：O(n)
 * */
public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待搜索的值：");
        int n = sc.nextInt();
        int[] A = new int[]{7, 3, 9, 6, 5};

        int index = Linear(A, n);
        if (index == -1) {
            System.out.println("没有该值");
        } else {
            System.out.println("索引值为：" + index);
        }
    }

    public static int Linear(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
