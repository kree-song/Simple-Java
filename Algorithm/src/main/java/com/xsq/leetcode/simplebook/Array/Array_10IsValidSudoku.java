package src.com.xsq.leetcode.simplebook.Array;

/*
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可
 *    1.数字 1-9 在每一行只能出现一次
 *    2.数字 1-9 在每一列只能出现一次
 *    3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 * */
public class Array_10IsValidSudoku {
    public static void main(String[] args) {
        char[][] arr = {{'5', '.', '3', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Array_10IsValidSudoku ivsk = new Array_10IsValidSudoku();
        System.out.println(ivsk.isValidSudoku(arr));
    }

    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        int[][] row = new int[len][len];
        int[][] column = new int[len][len];
        int[][] cell = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                //不存在则跳过
                if (board[i][j] == '.')
                    continue;
                //当前数字的值，-1是为了数组不越界
                int num = board[i][j] - '0' - 1;
                //找出对应cell
                int k = i / 3 * 3 + j / 3;
                //如果当前数字对应的行和列以及单元格，只要一个有该数字就说明冲突了，直接返回false。
                //举个例子，如果line[i][num]不等于0，说明第i（i从0开始）行有num这个数字。
                if (row[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0)
                    return false;
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                row[i][num] = column[j][num] = cell[k][num] = 1;
            }
        }
        return true;
    }
}
