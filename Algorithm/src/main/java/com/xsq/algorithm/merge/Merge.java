package com.xsq.algorithm.merge;

import java.util.Arrays;

/*
 * 合并：将两个按升序排列的数组合并为一个有序数组
 * 结论：1.执行算法MERGE将两个大小分别为n1和n2的非空数组合并成一个大小为n=n1+n2的排序数组，当n1<=n2时，
 *       元素比较次数在n1到n-1之间。特例是，如果两个数组大小为n/2和n/2，需要比较的次数在n/2到n-1之间。
 *      2.使用算法MERGE将两个大小分别为n的有序数组，元素赋值的次数恰好是2n
 * */
public class Merge {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 5, 6, 9};
        int[] B = new int[]{2, 4, 7, 11};
        int[] arr = Merge0(A, B);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] Merge0(int[] A, int[] B) {
        int i = 0, j = 0, k = 0;
        int[] res = new int[A.length + B.length];
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                res[k++] = A[i++];
            } else {
                res[k++] = B[j++];
            }
        }

        if (i != A.length) {//将剩余的数依次放进数组
            for (int a = i; a < A.length; a++) {
                res[k++] = A[a];
            }
        } else {
            for (int b = j; b < B.length; b++) {
                res[k++] = B[b];
            }
        }
        return res;
    }
}
