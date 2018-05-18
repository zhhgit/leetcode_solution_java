package session3.q054_spiral_matrix;

import session3.common.PrintUtil;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
        PrintUtil.print2DMatrix(matrix);
        System.out.println("---------------------");
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if(matrix.length == 0){
            return list;
        }
        if(matrix[0].length == 0){
            return list;
        }
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        int minDimen = Math.min(rowLen,columnLen);
        int round = minDimen / 2;
        for(int i = 0;i<round;i++){
            visitEachRound(list,matrix,i);
        }
        if(minDimen % 2 == 0){
            return list;
        }
        else{
            int remain = Math.abs(rowLen - columnLen) + 1;
            if(rowLen >= columnLen){
                for(int i = 0;i<remain;i++){
                    list.add(matrix[i+ round][columnLen / 2]);
                }
            }
            else{
                for(int i = 0;i<remain;i++){
                    list.add(matrix[rowLen / 2][i + round]);
                }
            }
        }
        return list;
    }

    private static void visitEachRound(List<Integer> list,int[][] matrix,int round){
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        //上边
        for(int i=round;i<=columnLen - 2 - round;i++){
            list.add(matrix[round][i]);
        }
        //右边
        for(int i = round;i<=rowLen - 2 - round;i++){
            list.add(matrix[i][columnLen - 1 - round]);
        }
        //下边
        for(int i = columnLen - 1 - round;i>=round + 1;i--){
            list.add(matrix[rowLen - 1 - round][i]);
        }
        //左边
        for(int i = rowLen - 1 - round;i>=round + 1;i--){
            list.add(matrix[i][round]);
        }
    }
}
