package com.xsq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        if (nums.length == 1) return new ArrayList<>(Arrays.asList(String.valueOf(nums[0])));
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]+1) {
                if (start == i-1) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[i-1]);
                }
                start = i;
            }
        }
        if (start == nums.length-1) {
            result.add(String.valueOf(nums[start]));
        } else {
            result.add(nums[start] + "->" + nums[nums.length-1]);
        }
        return result;
    }
}
