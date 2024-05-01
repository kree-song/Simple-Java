package src.com.xsq.leetcode.simplebook.String;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * 注意：若s和t中每个字符出现的次数都相同，则称s和t互为字母异位词
 */
public class String_04IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println(isAnagram2("rat", "car"));
    }

    //for循环
    private static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        boolean flag = false;
        for (int i = 0;i < sArr.length;i++) {
            for (int j = 0;j < tArr.length;j++) {
                if (sArr[i] == tArr[j]) {
                    tArr[j] = 'A';//找到目标字母则将其设置为一个非法值
                    flag = true;
                    break;
                }
            }

            //没找到就返回false，找到了就把flag设置为false
            if (!flag) {
                return false;
            } else {
                flag = false;
            }
        }
        return true;
    }

    //API调用
    private static boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr,tArr);
    }

    /**
     * 哈希表
     * t是s的异位词等价于「两个字符串中字符出现的种类和次数均相等」
     * 可维护一个长度为26的频次数组table，先遍历字符串s中字符出现的频次，然后遍历字符串t，减去table中的频次，
     * 如果出现table[i]<0，则说明t包含一个不在s中的频外字符
     */
    private static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (int i = 0;i < s.length();i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int j = 0;j < t.length();j++) {
            table[t.charAt(j) - 'a']--;
            if (table[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
