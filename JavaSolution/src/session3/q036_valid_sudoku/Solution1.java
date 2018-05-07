package session3.q036_valid_sudoku;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args){
        char[][] board = {".87654321".toCharArray(),"2........".toCharArray(),"3........".toCharArray(),"4........".toCharArray(),"5........".toCharArray(),"6........".toCharArray(),"7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()};
        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board) {
        //验证行
        for(int i=0;i<9;i++){
            List<Character> tempList = new LinkedList<>();
            for(int j = 0;j<9;j++){
                tempList.add(board[i][j]);
            }
            if(!isValidGroup(tempList)){
                return false;
            }
        }
        //验证列
        for(int i=0;i<9;i++){
            List<Character> tempList = new LinkedList<>();
            for(int j = 0;j<9;j++){
                tempList.add(board[j][i]);
            }
            if(!isValidGroup(tempList)){
                return false;
            }
        }
        //验证小区域
        for(int i=0;i<3;i++){
            for(int j = 0;j<3;j++){
                List<Character> tempList = new LinkedList<>();
                for(int k = 0;k<3;k++){
                    for(int l = 0;l<3;l++){
                        tempList.add(board[i*3 + k][j*3 + l]);
                    }
                }
                if(!isValidGroup(tempList)){
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean isValidGroup(List<Character> list){
        HashSet<Integer> hashSet = new HashSet<>();
        for(char c:list){
            if(c != '.' ){
                int num = c - '0';
                if(num <=0 || num > 9){
                    return false;
                }
                else{
                    if(!hashSet.contains(num)){
                        hashSet.add(num);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
