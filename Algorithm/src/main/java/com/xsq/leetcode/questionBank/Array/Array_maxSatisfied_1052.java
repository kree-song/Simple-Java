package com.xsq.leetcode.questionBank.Array;

import java.util.Arrays;

/**
 * 1052.爱生气的书店老板
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 */
public class Array_maxSatisfied_1052 {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
        System.out.println(maxSatisfied(new int[]{1},new int[]{0},1));
    }

    /**
     * O(n^2),O(1)
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        for (int i = 0; i < grumpy.length - minutes + 1; i++) {
            int count = 0;
            for (int j = 0; j < customers.length; j++) {
                if (grumpy[j] == 0 || (j >= i && j < i + minutes)) {
                    count += customers[j];
                }
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }

    /**
     * 滑动窗口
     * O(n),O(1)
     */
    public static int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int len = customers.length;
        //原始数据
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }

        int increase = 0;
        //先算出窗口在首位的情况
        for (int i = 0; i < minutes; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        //窗口向右移动，减去左边消失的，加上右边新增的
        for (int i = minutes; i < len; i++) {
            increase = increase - customers[i - minutes] * grumpy[i - minutes] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }
}
