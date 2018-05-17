package session3.q063_unique_paths_2;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(matrix));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        if(rowLen == 0){
            return 0;
        }
        int columnLen = obstacleGrid[0].length;
        if(columnLen == 0){
            return 0;
        }
        int[][] result = new int[rowLen][columnLen];
        for(int i = 0;i<rowLen;i++){
            for(int j = 0;j<columnLen;j++){
                if(obstacleGrid[i][j] == 1){
                    result[i][j] = 0;
                }
                else{
                    if(i == 0 && j == 0){
                        result[i][j] = 1;
                    }
                    else if(i == 0){
                        result[i][j] = result[i][j-1];
                    }
                    else if(j == 0){
                        result[i][j] = result[i-1][j];
                    }
                    else{
                        result[i][j] = result[i][j-1] + result[i-1][j];
                    }
                }
            }
        }
        return result[rowLen-1][columnLen-1];
    }
}
