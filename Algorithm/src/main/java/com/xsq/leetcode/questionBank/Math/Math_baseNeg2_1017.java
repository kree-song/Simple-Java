package src.com.xsq.leetcode.questionBank.Math;

/**
 * 1017.负二进制转换
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零
 */
public class Math_baseNeg2_1017 {
    public static void main(String[] args) {
        System.out.println(baseNeg2(2));//"110"
        System.out.println(baseNeg2(3));//"111"
        System.out.println(baseNeg2(4));//"100"
    }

    public static String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            res.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return res.reverse().toString();
    }
}
