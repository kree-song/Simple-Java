package com.xsq.lang.features.variableParameter;

/*
 * 需求：定义一个方法求N个数的和
 * */
public class testVariableParameter {
    public static void main(String[] args) {

        int sum1 = getSum(1, 2, 3, 4, 5);
        System.out.println(sum1);
    }

    public static int getSum(int... arr) {
        int sum = 0;
        /*for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
        }*/
        for (int i : arr) {
            sum = sum + i;
        }
        return sum;
    }
}
