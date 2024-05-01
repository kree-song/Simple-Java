package com.xsq.algorithm.sort;

import java.util.Arrays;

/*
 * 选择排序: 最好、最坏、平均时间复杂度均为：O(n^2)  空间复杂度：O(1) 不稳定 简单
 * 基本思想:每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，直到所有元素排完为止
 * 简单选择排序通过上面优化之后，无论数组原始排列如何，比较次数是不变的；
 * 对于交换操作，在最好情况下也就是数组完全有序的时候，无需任何交换移动，在最差情况下，也就是数组倒序的时候，交换次数为n-1次。综合下来，时间复杂度为O(n^2)
 * 结论：比较次数：n(n-1)/2 赋值次数：0-3(n-1)
 * */
public class C2SelectSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        select(arr);
        System.out.println(Arrays.toString(arr));
    }

    //！交换数组元素
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void select(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;//每一趟循环比较时，min存放较小元素的下标，这样当前批次比较完最终存放的就是此趟内最小元素的下标，避免每次遇到较小元素都要进行交换
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //若min发生变化则进行交换
            if (min != i) {
                swap(arr, min, i);
            }
        }
    }

}
