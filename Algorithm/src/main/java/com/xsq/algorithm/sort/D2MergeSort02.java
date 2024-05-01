package com.xsq.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 归并排序:最好，最坏，平均时间复杂度均为：O(nlogn) 空间复杂度：O(n) 稳定 较复杂
 * 稳定
 * */
public class D2MergeSort02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待排序数列的元素个数n：");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("请依次输入数列中的元素：");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);
        System.out.println("归并排序结果为：");
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];//建立一个长度等于原数组的临时数组，避免递归时频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并，使左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并，使右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子序列组合
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左子序列指针
        int j = mid + 1;//右子序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//左边剩余元素填充进temp
            temp[t++] = arr[i++];
        }
        while (j <= right) {//右剩余元素填充进temp
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {//将temp中的元素全部拷贝到原数组中
            arr[left++] = temp[t++];
        }
    }
}
