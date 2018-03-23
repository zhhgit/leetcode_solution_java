package session2.q063_unique_paths_2;

public class Solution1 {
    public static void main(String[] args){
        int[][] obstacleGrid = {{0,0,0,},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    private static int[][] matrix;

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        if(rowLen == 0){
            return 0;
        }
        int columnLen = obstacleGrid[0].length;
        if(columnLen == 0){
            return 0;
        }
        matrix = new int[rowLen][columnLen];
        for(int i = 0;i<rowLen;i++){
            for(int j = 0;j<columnLen;j++){
                //matrix[i][j]对应于位置obstacleGrid[rowLen-1-i][columnLen-1-j]
                if(obstacleGrid[rowLen-1-i][columnLen-1-j] == 1){
                    matrix[i][j] = 0;
                }
                else if(i == 0 && j ==0){
                    matrix[i][j] = 1;
                }
                else if(i == 0){
                    matrix[i][j] = matrix[i][j-1];
                }
                else if(j == 0){
                    matrix[i][j] = matrix[i-1][j];
                }
                else{
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
        }
        return matrix[rowLen-1][columnLen-1];
    }
}
