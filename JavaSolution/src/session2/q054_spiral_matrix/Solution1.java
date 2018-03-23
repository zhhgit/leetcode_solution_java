package session2.q054_spiral_matrix;

import session2.common.PrintUtil;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        PrintUtil.print2DMatrix(matrix);
        System.out.println(spiralOrder(matrix));
    }

    //在三种情况下需要单独处理，否则只要一层层访问即可
    /*
    * 1.行列相等，且长度为奇数
    * 2.行数大于列数，且列数为奇数
    * 2.行数小于列数，且行数为奇数*/
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int rowLen = matrix.length;
        if(rowLen == 0){
            return list;
        }
        int columnLen = matrix[0].length;
        int half = 0;
        //行列相等
        if(rowLen == columnLen){
            if(rowLen % 2 == 0){
                half = rowLen / 2;
            }
            else{
                half = (rowLen - 1) / 2;
            }
            //遍历每一层
            for(int i=0;i<half;i++){
                visitEachRound(matrix,list,i);
            }
            //如果是奇数，还有最中间的一个数字没有访问到
            if(rowLen % 2 == 1){
                list.add(matrix[rowLen/2][rowLen/2]);
            }
        }
        //列大于行
        else if(rowLen < columnLen){
            if(rowLen % 2 == 0){
                half = rowLen / 2;
            }
            else{
                half = (rowLen - 1) / 2;
            }
            //遍历每一层
            for(int i=0;i<half;i++){
                visitEachRound(matrix,list,i);
            }
            //如果是奇数，还有最中间的一行数字没有访问
            if(rowLen % 2 == 1){
                for(int i=half;i<columnLen-half;i++){
                    list.add(matrix[half][i]);
                }
            }
        }
        //行大于列
        else{
            if(columnLen % 2 == 0){
                half = columnLen / 2;
            }
            else{
                half = (columnLen - 1) / 2;
            }
            //遍历每一层
            for(int i=0;i<half;i++){
                visitEachRound(matrix,list,i);
            }
            //如果是奇数，还有最中间的一列数字没有访问
            if(columnLen % 2 == 1){
                for(int i=half;i<rowLen-half;i++){
                    list.add(matrix[i][half]);
                }
            }
        }
        return list;
    }

    //每一层的访问有四次循环，分别访问上右下左
    private static void visitEachRound(int[][] matrix,List<Integer> list,int index){
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        for(int i=index;i<columnLen - index -1;i++){
            list.add(matrix[index][i]);
        }
        for(int i=index;i<rowLen - index -1;i++){
            list.add(matrix[i][columnLen - 1 - index]);
        }
        for(int i=columnLen-1-index;i>=index + 1;i--){
            list.add(matrix[rowLen -1 -index][i]);
        }
        for(int i=rowLen-1-index;i>=index + 1;i--){
            list.add(matrix[i][index]);
        }
    }
}
