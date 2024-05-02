package com.xsq.leetcode.questionBank.Array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1329.将矩阵按对角线排序
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2]
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵
 */
public class Array_diagonalSort_1329 {
    public static void main(String[] args) {

    }

    public static int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        List<List<Integer>> diag = new ArrayList<>(m + n);
        for (int i = 0; i < m + n; i++) {
            diag.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diag.get(i - j + m).add(mat[i][j]);
            }
        }
        for (List<Integer> d : diag) {
            Collections.sort(d, Collections.reverseOrder());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                mat[i][j] = diag.get(i - j + m).removeLast();
            }
        }
        return mat;
    }
}
