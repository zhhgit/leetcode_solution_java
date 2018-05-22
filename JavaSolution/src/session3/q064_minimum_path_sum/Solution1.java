package session3.q064_minimum_path_sum;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        PrintUtil.print2DMatrix(grid);
        System.out.println("------------------");
        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        if(rowLen == 0){
            return 0;
        }
        int columnLen = grid[0].length;
        if(columnLen == 0){
            return 0;
        }
        int[][] result = new int[rowLen][columnLen];
        for(int i = 0;i<rowLen;i++){
            for(int j=0;j<columnLen;j++){
                if(i == 0 && j == 0){
                    result[i][j] = grid[i][j];
                }
                else if(i == 0){
                    result[i][j] = result[i][j-1] + grid[i][j];
                }
                else if(j == 0){
                    result[i][j] = result[i-1][j] + grid[i][j];
                }
                else{
                    result[i][j] = Math.min(result[i-1][j],result[i][j-1]) + grid[i][j];
                }
            }
        }
        return result[rowLen-1][columnLen-1];
    }
}
