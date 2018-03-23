package session1.q064_minimum_path_sum;

public class Solution1 {
    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},{1,6,7,8},{1,10,11,12}};
        System.out.println(minPathSum(arr));
    }

    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m>=1){
            int n = grid[0].length;
            int[][] arr = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if((i==0) && (j==0)){
                        arr[i][j] = grid[i][j];
                    }
                    else if((i==0) && (j>0)){
                        arr[i][j] = grid[i][j] + arr[i][j-1];
                    }
                    else if((j==0) && (i>0)){
                        arr[i][j] = grid[i][j] + arr[i-1][j];
                    }
                    else{
                        arr[i][j] = grid[i][j] + Math.min(arr[i-1][j], arr[i][j-1]);
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
