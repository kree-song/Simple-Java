package src.com.xsq.leetcode.simplebook.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 8.字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）
 * 函数myAtoi(string s) 的算法如下：
 * 1.读入字符串并丢弃无用的前导空格
 * 2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正
 * 3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略
 * 4.将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）
 * 5.如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31− 1 的整数应该被固定为 2^31− 1
 * 6.返回整数作为最终结果
 *
 * 注意：
 * 本题中的空白字符只包括空格字符 ' '
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符
 */
public class String_06MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));//42
        System.out.println(myAtoi("   -42"));//-42
        System.out.println(myAtoi("4193 with words"));//4193
        System.out.println(myAtoi("4193 with 21words"));//4193
    }

    /**
     * !确定有限状态机(deterministic finite automaton, DFA)
     * 处理方法：画自动机图->写-+出自动机表
     */
    private static int myAtoi(String s) {
        Automation automation = new Automation();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            automation.get(s.charAt(i));
        }
        return (int) (automation.sign * automation.ans);
    }
}

class Automation {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>(){{
        // 当前字符        下一字符: ' '    +/-    数字   其他
        put("start",new String[]{"start","signed","in_number","end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    //算出目前的sign和ans
    public void get(char c){
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans,(long) Integer.MAX_VALUE) : Math.min(ans,-(long)Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    //根据当前字符判断下一状态
    private int get_col(char c){
        if (c == ' '){
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
