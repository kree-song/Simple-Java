package src.com.xsq.leetcode.questionBank.Array;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
 */
public class Array_removeElement_27 {
    public static void main(String[] args) {
        System.out.println(removeElement2(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement2(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    //Stream流
    private static int removeElement(int[] nums, int val){
        nums = Arrays.stream(nums).filter(o -> o != val).toArray();
        return (int) Arrays.stream(nums).filter(o -> o != val).count();
    }

    //for循环
    private static int removeElement2(int[] nums, int val){
        int length = nums.length;
        int temp = 0;
        for (int j=0;j < length;j++) {
            if (nums[j] != val){
                if (j != temp) {
                    nums[j] = nums[j] + nums[temp];
                    nums[temp] = nums[j] - nums[temp];
                    nums[j] = nums[j] - nums[temp];
                }
                temp ++;
            }
        }
        return temp;
    }
}
