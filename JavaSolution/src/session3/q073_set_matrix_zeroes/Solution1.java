package session3.q073_set_matrix_zeroes;

import session3.common.PrintUtil;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        PrintUtil.print2DMatrix(matrix);
        setZeroes(matrix);
        System.out.println("----------------------");
        PrintUtil.print2DMatrix(matrix);
    }

    private static void setZeroes(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        if(matrix[0].length == 0){
            return;
        }
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        List<Integer> row = new LinkedList<>();
        List<Integer> column = new LinkedList<>();
        for(int i = 0;i<rowLen;i++){
            for(int j = 0;j<columnLen;j++){
                if(matrix[i][j] == 0){
                    if(!row.contains(i)){
                        row.add(i);
                    }
                    if(!column.contains(j)){
                        column.add(j);
                    }
                }
            }
        }
        for(int i:row){
            for(int j = 0;j<columnLen;j++){
                matrix[i][j] = 0;
            }
        }
        for(int i:column){
            for(int j = 0;j<rowLen;j++){
                matrix[j][i] = 0;
            }
        }
    }
}
