package com.xsq.leetcode.questionBank.Array;

/*
 * 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 * */
public class Array_maxProfit1_121 {
    public static void main(String[] args) {
        System.out.println(maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //暴力
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(prices[j] - prices[i], res);
            }
        }
        return res;
    }

    //贪心
    public static int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;//借助Integer最大值完成判断语句
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                //若当前值为当前最小，更新
                minprice = prices[i];
            } else if (prices[i] - minprice > max) {
                //若非当前最小，但利润大于当前最大，更新
                max = prices[i] - minprice;
            }
        }
        return max;
    }

    //动态规划
    public static int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];//当天晚上手里的钱，0不持股，1持股
        //定义边界条件
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //自第二天开始递归
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }

        return dp[len - 1][0];
    }

}

