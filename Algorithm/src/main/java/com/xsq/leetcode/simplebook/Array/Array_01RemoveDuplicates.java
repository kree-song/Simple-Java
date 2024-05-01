package src.com.xsq.leetcode.simplebook.Array;

/*
 * 删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * */
public class Array_01RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};//5
        Array_01RemoveDuplicates res = new Array_01RemoveDuplicates();
        System.out.println(res.removeDuplicates(arr));
    }

    //双指针
    public int removeDuplicates(int[] nums) {
        /*Stream stream = (Stream) Arrays.stream(nums);
        Stream stream02 = stream.distinct();
        int i= (int) stream02.count();
        return i;*/
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

}
