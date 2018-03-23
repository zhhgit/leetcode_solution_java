package session1.q073_set_matrix_zeros;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {{1,1,1,1},{1,0,1,1},{1,1,1,1}};
        setZeroes(matrix);
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void setZeroes(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==0){
                    if(!rowSet.contains(i)){
                        rowSet.add(i);
                    }
                    if(!columnSet.contains(j)){
                        columnSet.add(j);
                    }
                }
            }
        }
        for (Integer each : rowSet) {
            for(int j=0;j<column;j++){
                matrix[each][j] = 0;
            }
        }
        for (Integer each : columnSet) {
            for(int i=0;i<row;i++){
                matrix[i][each] = 0;
            }
        }
    }
}
