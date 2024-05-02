package com.xsq.leetcode.simplebook.Array;


import java.util.Arrays;

/*
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标
 * */
public class Array_09TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum02(arr, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = 1;
        while (nums[i] + nums[j] != target) {
            if (j == nums.length - 1) {
                i++;
                j = i;
            }
            j++;
        }
        return new int[]{i, j};
    }

    public static int[] twoSum02(int[] nums, int target) {
        int[] s = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    s[0] = i;
                    s[1] = j;
                }
            }
        }
        return s;
    }
}
