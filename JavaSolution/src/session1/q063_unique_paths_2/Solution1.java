package session1.q063_unique_paths_2;

public class Solution1 {
    public static void main(String[] args){
        int[][] arr = {{1,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m>=1){
            int n = obstacleGrid[0].length;
            int[][] arr = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(obstacleGrid[i][j]!=0){
                        arr[i][j] = 0;
                    }
                    else if((i==0) && (j==0)){
                        arr[i][j] = 1;
                    }
                    else if((i==0) && (j>0)){
                        arr[i][j] = arr[i][j-1];
                    }
                    else if((j==0) && (i>0)){
                        arr[i][j] = arr[i-1][j];
                    }
                    else{
                        arr[i][j] = arr[i-1][j] + arr[i][j-1];
                    }
                }
            }
            return arr[m-1][n-1];
        }
        else{
            return 0;
        }
    }
}
