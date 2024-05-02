package com.xsq.leetcode.questionBank.Array;

/**
 * 2798.满足目标工作时长的员工数目
 * 公司里共有 n 名员工，按从 0 到 n - 1 编号。每个员工 i 已经在公司工作了 hours[i] 小时
 * 公司要求每位员工工作 至少 target 小时
 * 给你一个下标从 0 开始、长度为 n 的非负整数数组 hours 和一个非负整数 target
 * 请你用整数表示并返回工作至少 target 小时的员工数
 */
public class Array_numberOfEmployeesWhoMetTarget_2798 {
    public static void main(String[] args) {
        System.out.println(numberOfEmployeesWhoMetTarget(new int[]{0,1,2,3,4},2));
        System.out.println(numberOfEmployeesWhoMetTarget(new int[]{5,1,4,2,2},6));
    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) {
                ans++;
            }
        }
        return ans;
    }
}
