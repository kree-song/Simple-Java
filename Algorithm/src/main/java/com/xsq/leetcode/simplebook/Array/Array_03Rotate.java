package src.com.xsq.leetcode.simplebook.Array;

import java.util.Arrays;

/*
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * */
public class Array_03Rotate {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};//{1,2,3,4,5,6,7} {-1,-100,3,99} {-1}
        int k = 3;
        Array_03Rotate r = new Array_03Rotate();
        r.rotate04(arr, k);
    }

    public void rotate(int[] nums, int k) {
        while (k > nums.length - 1)
            k = k - nums.length;
        int a = 0, b = (nums.length - 1);
        int[] arr = new int[nums.length];
        //把后k个数字复制到新数组前面k个
        for (int i = k - 1; i >= 0; i--) {
            arr[i] = nums[b--];
        }
        //把前nums.length-k复制到新数组后面
        for (int i = k; i < nums.length; i++) {
            arr[i] = nums[a++];
        }
        System.arraycopy(arr, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    //使用临时数组
    public void rotate02(int[] nums, int k) {
        int[] temp = new int[nums.length];
        //将原数组复制到临时数组中
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        //把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = temp[i];
        }

        System.out.println(Arrays.toString(nums));
    }

    //多次反转
    public void rotate03(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);//反转整个数组
        reverse(nums, 0, k - 1);//反转前k个数组
        reverse(nums, k, nums.length - 1);//反转后面的元素

        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public void rotate04(int[] nums, int k) {
        k = k % nums.length;
        int[] rightpart = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(rightpart, 0, nums, 0, k);

        System.out.println(Arrays.toString(nums));
    }

}
