package src.com.xsq.leetcode.simplebook.Array;

import java.util.Arrays;

/*
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * */
public class Array_08MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes02(arr);
        System.out.println(Arrays.toString(arr));
    }

    //从右向左遍历，若为0则将后面的数字前移一位，并将尾数置为0
    public static void moveZeroes(int[] nums) {
        if (nums == null) return;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
                nums[nums.length - 1] = 0;
            }
        }
    }

    //双指针
    public static void moveZeroes02(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                //交换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }


}
