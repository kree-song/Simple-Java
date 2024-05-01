package com.xsq.algorithm.sort;

import java.util.Arrays;

/*
 * 用算法自底向上的归并排序对n个元素的数组进行排序，当n为2的幂时，元素比较次数在(nlog2)/2到nlogn-n+1之间。
 * 执行该算法的元素赋值次数为2nlogn
 * */
public class D2MergeSortBU {
    public static void merge(int[] arr, int min, int mid, int max) {
        int i = min;
        int j = mid + 1;
        int[] aux = new int[arr.length];
        for (int k = 0; k < arr.length; k++) {
            aux[k] = arr[k];
        }
        for (int k = min; k <= max; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > max) {
                arr[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }

    }

    /**
     * 自底向上归并排序
     * 外层for循环控制子序列长度
     * 内层for循环控制子序列合并
     * 归并排序算法复杂度O(N²)
     *
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i = i + i) {
            for (int j = 0; j < arr.length - i; j = j + 2 * i) {
                merge(arr, j, j + i - 1, Math.min(j + 2 * i - 1, arr.length - 1));
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = sort(new int[]{3, 9, 5, 7, 1, 4, 8});
        System.out.println(Arrays.toString(arr));
    }
}
