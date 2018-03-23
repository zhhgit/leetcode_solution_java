package session1.q048_rotate_image;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int row = matrix.length;
        int column = matrix[0].length;
        rotate(matrix);
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i=0;i<row-1;i++){
            for(int j=i+1;j<column;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<row;i++){
            int left=0,right=column-1;
            while(right>left){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
