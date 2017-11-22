package q073_set_matrix_zeroes;

import common.PrintUtil;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,0,8},{9,10,11,12}};
        PrintUtil.print2DMatrix(matrix);
        setZeroes(matrix);
        System.out.println("----------------");
        PrintUtil.print2DMatrix(matrix);
    }

    private static void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        if(rowLen ==0){
            return;
        }
        int columnLen = matrix[0].length;
        if(columnLen == 0){
            return;
        }
        List<Integer> zeroRows = new LinkedList<>();
        List<Integer> zeroColumns = new LinkedList<>();
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<columnLen;j++){
                if(matrix[i][j] == 0){
                    if(!zeroRows.contains(i)){
                        zeroRows.add(i);
                    }
                    if(!zeroColumns.contains(j)){
                        zeroColumns.add(j);
                    }
                }
            }
        }
        setRows(matrix,zeroRows);
        setColumns(matrix,zeroColumns);
    }

    private static void setRows(int[][] matrix, List<Integer> rows){
        int columnLen = matrix[0].length;
        for(Integer row: rows){
            for(int i=0;i< columnLen;i++){
                matrix[row][i] = 0;
            }
        }
    }

    private static void setColumns(int[][] matrix, List<Integer> columns){
        int rowLen = matrix.length;
        for(Integer column: columns){
            for(int i=0;i< rowLen;i++){
                matrix[i][column] = 0;
            }
        }
    }
}
