package session2.q048_rotate_image;

import session2.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        PrintUtil.print2DMatrix(matrix1);
        System.out.println("---------------------");
        rotate(matrix1);
        PrintUtil.print2DMatrix(matrix1);

        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        PrintUtil.print2DMatrix(matrix2);
        System.out.println("---------------------");
        rotate(matrix2);
        PrintUtil.print2DMatrix(matrix2);
    }

    private static void rotate(int[][] matrix) {
        int len = matrix.length;
        if(len == 0){
            return;
        }
        int halfLen = 0;
        if(len % 2 == 0){
            halfLen = len / 2;
        }
        else{
            halfLen = (len-1) / 2;
        }
        int[] temp = new int[len];
        for(int i = 0;i<halfLen;i++){
            //这一层里面有五次循环，而不是依次循环！
            for(int j = i+1;j < len - i;j++ ){
                temp[j] = matrix[i][j];
            }
            for(int j = i+1;j < len - i;j++ ){
                matrix[i][j] = matrix[len -1-j][i];
            }
            for(int j = i+1;j < len - i;j++ ){
                matrix[len -1-j][i] = matrix[len - 1 - i][len - 1-j];
            }
            for(int j = i+1;j < len - i;j++ ){
                matrix[len -1 - i][len - 1-j] = matrix[j][len - 1 -i];
            }
            for(int j = i+1;j < len - i;j++ ){
                matrix[j][len - 1 -i] = temp[j];
            }
        }
    }
}
