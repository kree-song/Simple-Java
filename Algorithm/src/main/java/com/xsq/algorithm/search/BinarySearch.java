package com.xsq.algorithm.search;

import java.util.Scanner;

/*
 * 二分搜索：O(logn)
 * 构造决策树
 * */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待搜索的值：");
        int n = sc.nextInt();
        int[] A = new int[]{3, 5, 6, 7, 9};

        int index = Binary(A, n, 0, A.length - 1);

        if (index == -1) {
            System.out.println("没有该值");
        } else {
            System.out.println("索引值为：" + index);
        }
    }

    public static int Binary(int[] arr, int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;//>> 1
            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
