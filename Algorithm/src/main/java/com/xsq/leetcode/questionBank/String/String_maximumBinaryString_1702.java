package src.com.xsq.leetcode.questionBank.String;

/**
 * 1702.修改后的最大二进制字符串
 * 给你一个二进制字符串binary，它仅有0或者1组成。你可以使用下面的操作任意次对它进行修改
 * 操作1：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换，如"00010" -> "10010"
 * 操作2：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换，如"00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的最大二进制字符串。如果二进制字符串x对应的十进制数字大于二进制字符串y对应的十进制数字，那么我们称二进制字符串x大于二进制字符串y
 */
public class String_maximumBinaryString_1702 {
    public static void main(String[] args) {

    }

    /**
     * 科学归纳法
     * 对于任意两个0中间夹着n个1的情况，可以转化成“10”后跟n个1：00 -> 10, 010 -> 101, 0110 -> 0101 -> 0011 -> 1011, ...
     * 且该规律可作为子问题融入较大范围：010101 -> 101101 -> 110111, ...
     * 进而发现处理后的字符串0后面跟着的1数量即为原字符串中1的总数，0前用1补齐即可，考虑到特殊情况，对于1开头的字符串，第一个0前面所有1不做处理
     */
    public static String maximumBinaryString(String binary) {
        int c0 = 0, c1 = 0, n = binary.length();
        for (char c : binary.toCharArray()) {
            c0 += '1' - c; //计算0的数目
            c1 += c0 > 0 ? c - '0' : 0; //从第一个0开始计算1的个数
        }
        return "";
//        return c0 < 2 ? binary : "1".repeat(n - c1 - 1) + '0' + "1".repeat(c1);//java11API
    }
}
