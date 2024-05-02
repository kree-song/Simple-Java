package com.xsq.leetcode.questionBank.Array;

import java.util.Arrays;

/*
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数
 * 算法的时间复杂度应该为 O(log (m+n))
 * */
public class Array_findMedianSortedArrays_4 {
    public static void main(String[] args) {

    }

    //暴力api
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;//除以2.0才是真除
        } else {
            return arr[arr.length / 2];
        }
    }
}
