package com.xsq.algorithm.sort;

import java.util.Arrays;

public class D2MergeSort03 {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {//如果是空数组或数组只有一个数，直接返回
            return;
        }
        SortProcess(arr, 0, arr.length - 1);//0~n-1
    }

    public static void SortProcess(int[] arr, int l, int r) {
        if (l == r) {//只有一个数，直接返回
            return;
        }
        int mid = l + ((r - l) >> 1);//l和r中点的位置(l + r)/2
        SortProcess(arr, l, mid);//T(n/2)
        SortProcess(arr, mid + 1, r);//T(n/2)
        merge(arr, l, mid, r);//O(N)
        //T(N) = 2 T(N/2) + O(N)
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个必有且只有一个越界
        //两个while只会进行一个
        while (p1 <= mid) {//潜台词：p2必越界
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {//潜台词：p1必越界
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

//    public static void main(String[] args) {
//        int[] arr1 = {1, 3, 6, 4};
//        mergeSort(arr1);
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.println(arr1[i]);
//        }
//    }
}
