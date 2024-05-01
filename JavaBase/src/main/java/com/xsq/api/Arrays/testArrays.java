package com.xsq.api.Arrays;

import java.util.Arrays;

public class testArrays {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 16, 4};
        int[] arr2 = {5, 3, 8, 16, 4};
        int[][] arr3 = new int[2][3];
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.equals(arr, arr2));
        System.out.println(arr3.length + "\t" + arr3[1].length);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, 5));
    }
}
