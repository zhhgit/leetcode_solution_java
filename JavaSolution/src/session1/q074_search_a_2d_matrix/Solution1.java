package session1.q074_search_a_2d_matrix;

import java.util.*;

public class Solution1 {
    public static  void main(String[] args){
        int[][] matrix = {{1}};
        int target = 2;
        System.out.println(searchMatrix(matrix,target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> list = new LinkedList<>();
        int row = matrix.length;
        if(row!=0){
            int column = matrix[0].length;
            if(column!=0){
                for(int i=0;i<row;i++){
                    for(int j=0;j<column;j++){
                        list.add(matrix[i][j]);
                    }
                }
                int i=0;
                while((i<list.size()) && (list.get(i)<target)){
                    i++;
                }
                if(i==list.size()){
                    return false;
                }
                else if(list.get(i) == target){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
