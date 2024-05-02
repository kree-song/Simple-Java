package com.xsq.leetcode.questionBank.Array;

import java.util.Arrays;

/*
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false
 **/
public class Array_containsDuplicate_217 {
    public static void main(String[] args) {
        int[] arr = new int[]{};
        System.out.println(containsDuplicate1(arr));

    }

    public static boolean containsDuplicate1(int[] nums) {
        int count = (int) Arrays.stream(nums).distinct().count();
        if (nums.length != count) {
            return true;
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
