package src.com.xsq.leetcode.simplebook.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集
 * */
public class Array_06Intersect {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        Array_06Intersect i = new Array_06Intersect();
        int[] intersect = i.intersect02(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    //指针法
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] arr = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            arr[k] = list.get(k);
        }
        return arr;
    }

    //利用map
    public int[] intersect02(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        //先把数组nums1的所有元素都存放到map中，其中key是数组的元素，value是这个元素出现在数组中的次数
        for (int i = 0; i < nums1.length; i++) {
            hm.put(nums1[i], hm.getOrDefault(nums1[i], 0) + 1);
        }

        //遍历nums2数组，查看map中是否包含nums2的元素，如果包含，就把当前值加入到集合list中，然后再把对应的value值减1
        for (int i = 0; i < nums2.length; i++) {
            if (hm.getOrDefault(nums2[i], 0) > 0) {
                list.add(nums2[i]);
                hm.put(nums2[i], hm.get(nums2[i]) - 1);
            }
        }

        int[] arr = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            arr[k] = list.get(k);
        }
        return arr;
    }
}
