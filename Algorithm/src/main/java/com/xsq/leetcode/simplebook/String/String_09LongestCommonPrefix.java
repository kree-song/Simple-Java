package src.com.xsq.leetcode.simplebook.String;

/**
 * 14.最长公共前缀
 * 查找字符串数组中的最长公共前缀,如果不存在公共前缀，返回空字符串 ""
 */
public class String_09LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }

    //找出最短的字符串，以此作为基准和各个字符串比较
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String str = findShortest(strs);
        for (int j = 0; j < str.length(); j++) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(j) != str.charAt(j)) {
                    return str.substring(0, j);
                }
            }
        }
        return str;

    }

    //找出最短的字符串
    private static String findShortest(String[] strs) {
        int j = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < strs[0].length()) {
                j = i;
            }
        }
        return strs[j];
    }
}
