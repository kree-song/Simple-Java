package com.xsq.leetcode.simplebook.String;

import java.util.ArrayList;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串
 * 字母和数字都属于字母数字字符
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false
 */
public class String_05IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome3("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome2("race a car"));
//        System.out.println(isPalindrome3("rac1 a 1car"));
//        System.out.println(isPalindrome2(" "));
//        System.out.println(isPalindrome2("\"OP\""));
    }

    //双指针
    private static boolean isPalindrome(String s){
        String str = s.toLowerCase();
        ArrayList<Character> list = new ArrayList<>(2);
        for (int i = 0;i < str.length();i++) {
            if((str.charAt(i) - 'a' >= 0 && 'z' - str.charAt(i) >= 0)
                    || (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                list.add(str.charAt(i));
            }
        }
        int i = 0;
        int j = list.size() - 1;
        while (i<=j){
            if (list.get(i) - list.get(j) != 0){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //API
    private static boolean isPalindrome2(String s){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
//        StringBuffer sb_rev = sb.reverse();//TODO StringBuffer (leetcode中此行此用例过不了 "race a car")
        StringBuffer sb_rev = new StringBuffer(sb).reverse();
        return sb.toString().equals(sb_rev.toString());
    }

    /**
     * 在原字符串上直接判断 [空间复杂度：O(1)]
     * 每次将指针移到下一个字母字符或数字字符，再判断这两个指针指向的字符是否相同
     */
    private static boolean isPalindrome3(String s) {
        int left = 0,right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
