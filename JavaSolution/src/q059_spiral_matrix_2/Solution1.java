package q059_spiral_matrix_2;

import common.PrintUtil;
public class Solution1 {
    public static void main(String[] args){
        int n = 5;
        PrintUtil.print2DMatrix(generateMatrix(n));
    }

    private static int num = 1;

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int half = n / 2;
        for(int i=0;i<half;i++){
            visitEachRound(matrix,i);
        }
        if(n % 2 == 1){
            matrix[half][half] = num++;
        }
        return matrix;
    }

    //每一层的访问有四次循环，分别访问上右下左
    private static void visitEachRound(int[][] matrix,int index){
        int len = matrix.length;
        for(int i=index;i<len - index -1;i++){
            matrix[index][i] = num++;
        }
        for(int i=index;i<len - index -1;i++){
            matrix[i][len - 1 - index] = num++;
        }
        for(int i=len-1-index;i>=index + 1;i--){
            matrix[len -1 -index][i] = num++;
        }
        for(int i=len-1-index;i>=index + 1;i--){
            matrix[i][index] = num++;
        }
    }
}
