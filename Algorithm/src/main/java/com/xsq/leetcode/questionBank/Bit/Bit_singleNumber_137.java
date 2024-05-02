package com.xsq.leetcode.questionBank.Bit;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现一次外，其余每个元素都恰出现三次.请你找出并返回那个只出现了一次的元素
 * */
public class Bit_singleNumber_137 {
    public static void main(String[] args) {

    }

    //位运算：答案的第i个二进制位就是数组中所有元素的第i个二进制位之和除以3的余数
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            //取得每个数的第i位求和
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            //找到唯一的数的第i位还原
            if (total % 3 != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    //api
    public static int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        AtomicInteger res = new AtomicInteger();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        hm.forEach((Integer key, Integer value) -> {
            if (value == 1) {
                res.set(key);
            }
        });
        return res.get();
    }
}
