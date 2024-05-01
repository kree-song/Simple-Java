package com.xsq.algorithm.divide_conquer;

import java.util.Scanner;

/*
 * 贪吃蛇问题：m*n,左上贪吃蛇吃右下果
 * */
public class loveEatSnake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int res = solution(m, n);
        System.out.println(res);
    }

    public static int solution(int m, int n) {
        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return solution(m - 1, n) + solution(m, n - 1);
    }
}
