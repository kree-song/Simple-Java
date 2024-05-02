package com.xsq.leetcode.questionBank.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2007.从双倍数组中还原原数组
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回
 */
public class Array_findOriginalArray_2007 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1,3,4,2,6,8})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{6,3,0,1})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{4,2,0})));
    }

    /**
     * 超时
     */
    public static int[] findOriginalArray2(int[] changed) {
        Arrays.sort(changed);
        ArrayList<Integer> original = new ArrayList<>();
        for (int i = 0; i < changed.length; i++) {
            for (int j = i + 1; j < changed.length; j++) {
                if (changed[j] == 2 * changed[i]) {
                    original.add(changed[i]);
                    changed[i] = -1;
                    changed[j] = -1;
                }
            }
        }

        for (int i = 0; i < changed.length; i++) {
            if (changed[i] >= 0) {
                return new int[]{};
            }
        }
        int[] res = new int[original.size()];
        int i = 0;
        for (Integer o : original) {
            res[i] = o;
            i++;
        }
        return res;
    }

    /**
     * O(nlogn)、O(n)
     */
    public static int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        Map<Integer, Integer> count = new HashMap<>();//存储有序？
        for (int a : changed) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        int[] res = new int[changed.length / 2];
        int i = 0;
        for (int a : changed) {//必须有序
            if (count.get(a) == 0) {
                continue;
            }
            count.put(a, count.get(a) - 1);
            if (count.getOrDefault(a * 2, 0) == 0) {
                return new int[0];
            }
            count.put(a * 2, count.get(a * 2) - 1);
            res[i++] = a;
        }
        return res;
    }
}

