package src.com.xsq.leetcode.questionBank.Bit;

/*
 * 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）
 * 输入为 非空 字符串且只包含数字 1 和 0
 * */
public class Bit_addBinary_67 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    //api
    public static String addBinary(String a, String b) {
        //要求：1 <= a.length, b.length <= 10^4
        //int：32bit
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    //模拟计算过程
    public static String addBinary2(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

    //位运算
    /*
    *
    * 把 a 和 b 转换成整型数字 x 和 y，在接下来的过程中，x 保存结果，y 保存进位。
      当进位不为 0 时
      计算当前 x 和 y 的无进位相加结果：answer = x ^ y
      计算当前 x 和 y 的进位：carry = (x & y) << 1
      完成本次循环，更新 x = answer，y = carry
      返回 x 的二进制形式
    * */
    public static String addBinary3(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int answer = 0;
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            answer = Integer.parseInt(a, 2) ^ Integer.parseInt(b, 2);
        }

        return null;
    }

}
