package session1.q054_spiral_matrix;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {};
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int row = matrix.length;
        if(row>0){
            int column = matrix[0].length;
            backTracking(list,matrix,column,row);
        }
        return list;
    }

    private static void backTracking(List<Integer> list,int[][] matrix,int remainDimenX,int remainDimenY){
        int row = matrix.length;
        int column = matrix[0].length;
        int halfExt = (row-remainDimenY)/2;
        if((remainDimenX==0) || (remainDimenY==0)){
            return;
        }
        else if((remainDimenX==1) && (remainDimenY>=1)){
            for(int i=halfExt;i<remainDimenY+halfExt;i++){
                list.add(matrix[i][column/2]);
            }
        }
        else if((remainDimenY==1) && (remainDimenX>1)){
            for(int j=halfExt;j<remainDimenX+halfExt;j++){
                list.add(matrix[row/2][j]);
            }
        }
        else{
            for(int j=halfExt;j<remainDimenX+halfExt;j++){
                list.add(matrix[halfExt][j]);
            }
            for(int i=halfExt+1;i<remainDimenY+halfExt;i++){
                list.add(matrix[i][column-halfExt-1]);
            }
            for(int j=remainDimenX+halfExt-2;j>=halfExt;j--){
                list.add(matrix[row-halfExt-1][j]);
            }
            for(int i=remainDimenY+halfExt-2;i>=halfExt+1;i--){
                list.add(matrix[i][halfExt]);
            }
            backTracking(list,matrix,remainDimenX-2,remainDimenY-2);
        }
    }
}
