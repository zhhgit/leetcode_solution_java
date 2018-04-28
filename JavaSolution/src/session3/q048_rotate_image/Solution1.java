package session3.q048_rotate_image;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[][][] matrixs = {{{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7}, {15,14,12,16}},{{1,2,3},{4,5,6},{7,8,9}}};
        for(int[][] matrix:matrixs){
            PrintUtil.print2DMatrix(matrix);
            System.out.println("--------------------------");
            rotate(matrix);
            PrintUtil.print2DMatrix(matrix);
            System.out.println("--------------------------");
        }
    }

    private static void rotate(int[][] matrix) {
        int len = matrix.length;
        int round = len / 2;
        for(int i = 0;i<round;i++){
            int eachRoundLen = len - 2 * i -1;
            int[] temp = new int[eachRoundLen];
            for(int j = 0;j<eachRoundLen;j++){
                temp[j] = matrix[i][i+j];
            }
            for(int j = 0;j<eachRoundLen;j++){
                matrix[i][i+j] = matrix[len-1-i-j][i];
            }
            for(int j = 0;j<eachRoundLen;j++){
                matrix[len-1-i-j][i] = matrix[len-1-i][len-1-i-j];
            }
            for(int j = 0;j<eachRoundLen;j++){
                matrix[len-1-i][len-1-i-j] = matrix[i+j][len-1-i];
            }
            for(int j = 0;j<eachRoundLen;j++){
                matrix[i+j][len-1-i] = temp[j];
            }
        }
    }
}
