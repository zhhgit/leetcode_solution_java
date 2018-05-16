package session3.q062_unique_paths;

public class Solution1 {
    public static void main(String[] args){
        int m = 7, n = 3;
        System.out.println(uniquePaths(m,n));
    }

    private static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        int[][] matrix = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0){
                    matrix[i][j] = 1;
                }
                else{
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
        }
        return matrix[m-1][n-1];
    }
}
