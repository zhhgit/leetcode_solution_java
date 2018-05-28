package session3.q059_spiral_matrix_2;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int n = 3;
        PrintUtil.print2DMatrix(generateMatrix(n));
    }

    private static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int num = 1;
        boolean oddFlag = (n % 2) == 1;
        int round = n / 2;
        for(int i = 0;i<round;i++){
            for(int j = i;j < n-1-i;j++){
                ret[i][j] = num++;
            }
            for(int j = i;j < n-i-i;j++){
                ret[j][n-1-i] = num++;
            }
            for(int j = n- 1 - i;j > i;j--){
                ret[n-1-i][j] = num++;
            }
            for(int j = n- 1 - i;j>i;j--){
                ret[j][i] = num++;
            }
        }
        if(oddFlag){
            ret[n/2][n/2] = num;
        }
        return ret;
    }
}
