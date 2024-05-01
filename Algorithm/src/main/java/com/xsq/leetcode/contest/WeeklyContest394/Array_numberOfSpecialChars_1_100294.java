package src.com.xsq.leetcode.contest.WeeklyContest394;

import java.util.Arrays;

/**
 * 100294.统计特殊字母的数量 I
 * 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母
 * 返回 word 中 特殊字母 的数量
 */
public class Array_numberOfSpecialChars_1_100294 {
    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("aaAbcBC"));
        System.out.println(numberOfSpecialChars("abc"));
        System.out.println(numberOfSpecialChars("abBCab"));
        System.out.println(numberOfSpecialChars("a"));
    }

    public static int numberOfSpecialChars(String word) {
        char[] arr = word.toCharArray();
        int[] arrInt = new int[arr.length];
        int m = 0;
        for (char c : arr) {
            arrInt[m++] = c;
        }
        arrInt = Arrays.stream(arrInt).distinct().toArray();

        int count = 0;
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = i+1; j < arrInt.length; j++) {
                if (Math.abs(arrInt[i] - arrInt[j]) == 32) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 构造空间存放数据
     */
    public static int numberOfSpecialChars2(String word){
        boolean[] data = new boolean[128];
        for (char c : word.toCharArray()) {
            data[(int)c] = true;
        }
        int ans = 0;
        //全局遍历
        for (int i = 'a'; i <= 'z'; i++) {
            if (data[i] && data[i - 'a' + 'A']){
                ans++;
            }
        }
        return ans;
    }

}
