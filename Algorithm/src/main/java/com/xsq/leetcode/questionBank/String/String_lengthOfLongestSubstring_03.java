package src.com.xsq.leetcode.questionBank.String;

import java.util.HashSet;

/*
 * 无重复字符的最长子串：找出其中不含有重复字符的 最长子串 的长度
 * 解决方案：窗体移动法
 *         数据结构的选择：可判断是否含有某元素
 * */
public class String_lengthOfLongestSubstring_03 {
    public static void main(String[] args) {
        String_lengthOfLongestSubstring_03 s = new String_lengthOfLongestSubstring_03();
        int res = s.lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> occ = new HashSet<>();
        int n = s.length();
        int r = -1, answer = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                //左指针向右移动
                occ.remove(s.charAt(i - 1));
            }
            //注意此时的r+1<n,总是判断下一个是否在Set内，故r[max]=6
            while (r + 1 < n && !occ.contains(s.charAt(r + 1))) {
                //移动右指针
                occ.add(s.charAt(r + 1));
                ++r;
            }
            answer = Math.max(answer, r - i + 1);

        }
        return answer;
    }
}
