package com.xsq.leetcode.contest.BiweeklyContest128;

/**
 * 100270.字符串的分数
 * 给你一个字符串 s 。一个字符串的 分数 定义为相邻字符 ASCII 码差值绝对值的和
 * 请你返回 s 的 分数
 *
 */
public class String_scoreOfString_1_100270 {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(scoreOfString(str));
        String str2 = "zaz";
        System.out.println(scoreOfString(str2));
    }

    public static int scoreOfString(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            res += Math.abs(chars[i] - chars[i+1]);
        }
          return res;
    }

}
