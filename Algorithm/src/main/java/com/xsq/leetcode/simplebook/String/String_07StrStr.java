package com.xsq.leetcode.simplebook.String;

/**
 * 28.实现strStr
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是 haystack 的一部分，则返回 -1
 */
public class String_07StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    //API
    private static int strStr(String haystack, String needle){
        return haystack.indexOf(needle);//KMP算法
    }
}
