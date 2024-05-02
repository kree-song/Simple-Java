package com.xsq.leetcode.questionBank.Array;

import java.util.Arrays;

/**
 * 2639.查询网格图中每一列的宽度
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 。矩阵中某一列的宽度是这一列数字的最大 字符串长度
 * 比方说，如果 grid = [[-10], [3], [12]] ，那么唯一一列的宽度是 3 ，因为 -10 的字符串长度为 3
 * 请你返回一个大小为 n 的整数数组 ans ，其中 ans[i] 是第 i 列的宽度
 * 一个有 len 个数位的整数 x ，如果是非负数，那么 字符串长度 为 len ，否则为 len + 1
 */
public class Array_findColumnWidth_2639 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findColumnWidth(new int[][]{{1},{22},{333}})));//[3]
        System.out.println(Arrays.toString(findColumnWidth(new int[][]{{-15,1,3},{15,7,12},{5,6,-2}})));//[3,1,2]
    }

    /**
     * 暴力解法
     */
    public static int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];
        Arrays.fill(ans,0);

        for (int[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                if (String.valueOf(row[i]).length() > ans[i]) {
                    ans[i] = String.valueOf(row[i]).length();
                }
            }
        }
        return ans;
    }

}
