package com.xsq.leetcode.simplebook.String;

import java.util.HashMap;
import java.util.Map;

/*
 * 字符串中的第一个唯一字符
 * 给定一个字符串s,找到它的第一个不重复的字符,并返回它的索引.如果不存在,则返回 -1
 * */
public class String_03FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar04("aabb"));//aaabb,abcaa,leetcode

    }

    //75.73%,13.30%
    //改后：83.8%，34%
    //空间1,时间n
    public static int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //将字母对应的索引值标记
            arr[s.charAt(i) - 97]++;
            /*int a=s.charAt(i)-97;
            if(arr[a]==0){
                arr[a] = 1;
            }else if(arr[a]>=1) {
                arr[a] = 2;
            }*/
        }
        for (int j = 0; j < s.length(); j++) {
            if (arr[s.charAt(j) - 97] == 1) {
                return j;
            }
        }
        return -1;
    }

    //双指针
    public static int firstUniqChar02(String s) {
        if (s.length() == 1) {
            return 0;
        }
        int p = 0, q = 1;
        char[] chars = s.toCharArray();
        while (q < chars.length) {
            if (chars[p] != chars[q]) {
                q++;
            } else {
                if (p == q - 1) {

                }
            }
        }
        return p;
    }

    //53.47%,30.68%
    //使用HashMap解决
    public static int firstUniqChar03(String s) {
        Map<Character, Integer> hs = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (hs.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    //59.7%,19.32%
    //使用api
    public static int firstUniqChar04(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }


}
