package com.xsq.algorithm.sort;
/*
 * 直接插入排序: 平均时间复杂度：O(n^2) 空间复杂度：O(1) 稳定 简单
 * 基本思想: 每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 * 简单插入排序在最好情况下，需要比较n-1次，无需交换元素，时间复杂度为O(n);在最坏情况下，时间复杂度依然为O(n2)。
 * 结论：比较次数：(n-1)-n(n-1)/2 赋值次数：比较次数+n-1
 * */

import java.util.Arrays;

public class A2InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    //！交换数组元素
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void insertion(int[] arr) {//从前往后排序，依次将到目前为止的数列排序
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }
}
