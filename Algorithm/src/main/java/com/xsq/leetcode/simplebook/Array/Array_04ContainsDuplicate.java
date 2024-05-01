package src.com.xsq.leetcode.simplebook.Array;

import java.util.Arrays;
import java.util.HashSet;

/*
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
 * */
public class Array_04ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        Array_04ContainsDuplicate cd = new Array_04ContainsDuplicate();
        System.out.println(cd.containsDuplicate(arr));
    }

    //排序后检测相邻元素是否有重复
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    //利用Set去重
    public boolean containsDuplicate02(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //if(!hashSet.add(nums[i])) return true;
            hs.add(nums[i]);
        }
        return hs.size() != nums.length;
    }

}
