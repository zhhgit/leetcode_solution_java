package session2.q064_minimum_path_sum;

public class Solution1 {
    public static void main(String[] args){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    private static int[][] matrix;

    private static int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        if(rowLen == 0){
            return 0;
        }
        int columnLen = grid[0].length;
        if(columnLen == 0){
            return 0;
        }
        matrix = new int[rowLen][columnLen];
        for(int i = 0;i<rowLen;i++){
            for(int j = 0;j<columnLen;j++){
                if(i == 0 && j ==0){
                    matrix[i][j] = grid[i][j];
                }
                else if(i == 0){
                    matrix[i][j] = matrix[i][j-1] + grid[i][j];
                }
                else if(j == 0){
                    matrix[i][j] = matrix[i-1][j] + grid[i][j];
                }
                else{
                    matrix[i][j] = Math.min(matrix[i-1][j],matrix[i][j-1]) + grid[i][j];
                }
            }
        }
        return matrix[rowLen-1][columnLen-1];
    }
}
