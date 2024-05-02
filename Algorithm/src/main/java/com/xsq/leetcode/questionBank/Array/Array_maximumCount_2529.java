package com.xsq.leetcode.questionBank.Array;

/**
 * 2529.正整数和负整数的最大计数
 * 给你一个按非递减顺序排列的数组nums，返回正整数数目和负整数数目中的最大值
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值
 */
public class Array_maximumCount_2529 {
    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-2,-1,-1,1,2,3}));
    }

    /**
     * 暴力解法
     */
    private static int maximumCount(int[] nums) {
        int a = 0,b = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] > 0) {
                a++;
            } else if (nums[i] < 0) {
                b++;
            }
        }
        return a >= b ? a : b;
    }

    /**
     * 二分查找
     * 由于数组呈现非递减顺序，因此可通过二分查找定位第一个数值大于等于0的位置pos1及第一个数值大于等于1的下标pos2
     * 假定n表示数组长度，且数组下标从0，则负数的个数为pos1，正数的个数为 n−pos2，返回这两者的较大值即可
     */
    private static int maximumCount2(int[] nums) {
        int pos1 = lowerBound(nums, 0);
        int pos2 = lowerBound(nums, 1);
        return Math.max(pos1, nums.length - pos2);
    }

    private static int lowerBound(int[] nums, int val){
        int l = 0,r = nums.length;
        while (l < r) {
            int m = (l + r)/2;
            if (nums[m] >= val) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
