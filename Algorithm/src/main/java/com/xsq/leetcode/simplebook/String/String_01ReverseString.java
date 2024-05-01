package src.com.xsq.leetcode.simplebook.String;

import java.util.Arrays;

public class String_01ReverseString {
    public static void main(String[] args) {
        char[] ch = {'h', 'e', 'l', 'l', 'o'};
        reverseString(ch);
        System.out.println(Arrays.toString(ch));
    }

    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char a;
        while (i < j) {
            a = s[j];
            s[j] = s[i];
            s[i] = a;
            i++;
            j--;
        }
    }
}
