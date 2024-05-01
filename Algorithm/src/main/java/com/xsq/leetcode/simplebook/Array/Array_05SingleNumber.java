package src.com.xsq.leetcode.simplebook.Array;

import java.util.HashSet;

/*
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * */
public class Array_05SingleNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 1, 2};
        Array_05SingleNumber sn = new Array_05SingleNumber();
        System.out.println(sn.singleNumber02(arr));
    }

    //利用Set去重
    public int singleNumber(int[] nums) {
        HashSet hs = new HashSet();
        for (int num : nums) {
            if (!hs.add(num)) {
                hs.remove(num);
            }
        }
        return (int) hs.toArray()[0];
    }

    /*
     * 异或运算
     * 1.相异为真，相同为假：a^a = 0 ，0^a = a
     * 2.满足交换律：a^b^a = a^a^b = b
     * */
    public int singleNumber02(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
