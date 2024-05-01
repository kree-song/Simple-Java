package src.com.xsq.leetcode.contest.WeeklyContest394;

import java.util.Arrays;

/**
 * 100291.统计特殊字母的数量 II
 * 给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母
 * 返回 word 中 特殊字母 的数量
 */
public class Array_numberOfSpecialChars_2_100291 {
    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("aaAbcBC"));
        System.out.println(numberOfSpecialChars("abc"));
        System.out.println(numberOfSpecialChars("AbBCab"));
        System.out.println(numberOfSpecialChars("a"));
        System.out.println(numberOfSpecialChars("cCceDC"));
        System.out.println(numberOfSpecialChars("AbcbDBdD"));//1
    }


    /**
     * 构造空间存放数据
     */
    public static int numberOfSpecialChars(String word) {
        int[] data = new int[128];
        Arrays.fill(data,-1);
        int index = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z'){
                //取最后一个小写字母
                data[c] = index;
            } else if (c >= 'A' && c <= 'Z' && data[c] == -1) {
                //取第一个大写字母
                data[c] = index;
            }
            index++;
        }

        int ans = 0;
        //全局遍历
        for (int i = 'a'; i <= 'z'; i++) {
            if (data[i] != -1 && data[i] < data[i - 'a' + 'A']){
                //若最后一个小写字母在第一个大写字母之前则ans+1
                ans++;
            }
        }
        return ans;
    }
}
