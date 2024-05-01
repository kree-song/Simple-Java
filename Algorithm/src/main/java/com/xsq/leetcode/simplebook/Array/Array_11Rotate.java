package src.com.xsq.leetcode.simplebook.Array;

import java.util.Arrays;

/**
 * 48.旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像
 */
public class Array_11Rotate {
    public static void main(String[] args){
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};//{{7,4,1},{8,5,2},{9,6,3}}
        rotate2(matrix1);
        for (int i = 0; i < matrix1.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};//{{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}}
        rotate2(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
    }

    /**
     * 使用辅助数组
     * 关系：对于矩阵中的第i行的第j个元素，在旋转后，它出现在倒数第i列的第j个位置  4*4:(2,3)->(3,3)
     *      matrix[row][col] -> matrix[col][n-row-1]
     */
    private static void rotate(int[][] matrix){
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }

    /**
     * 原地旋转
     * 处理点: 1.利用matrix[i][j] = matrix[n-j-1][i]找出参与旋转的4个点的坐标(矩阵永远是4个点互相交换)
     *        2.画图推理出i和j的边界值
     * @param matrix
     */
    private static void rotate2(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

    /**
     * 利用数学关系，用翻转代替旋转(从每个数的路途推出)
     * 处理点: 1.90度顺时针旋转 = 先水平翻转 + 后主对角线翻转
     *        2.推理出i和j的边界值
     */
    private static void rotate3(int[][] matrix){
        int n = matrix.length;
        //水平翻转
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        //主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
