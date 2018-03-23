package session2.q062_unique_paths;

public class Solution1 {
    public static void main(String[] args){
        int m = 23,n = 12;
        System.out.println(uniquePaths(m,n));
    }

    private static int[][] matrix;

    private static int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        if(m == 1 || n == 1){
            return 1;
        }
        matrix = new int[m][n];
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
