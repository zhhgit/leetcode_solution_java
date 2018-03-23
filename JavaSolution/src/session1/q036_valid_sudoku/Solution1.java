package session1.q036_valid_sudoku;

import java.lang.*;
import java.util.HashSet;

public class Solution1 {
    public static void main(String[] args) {
        char[][] s1 = {".87654321".toCharArray(),"2........".toCharArray(),"3........".toCharArray(),"4........".toCharArray(),"5........".toCharArray(),"6........".toCharArray(),"7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()};
        char[][] s2 = {"..5.....6".toCharArray(),"....14...".toCharArray(),".........".toCharArray(),".....92..".toCharArray(),"5....2...".toCharArray(),".......3.".toCharArray(),"...54....".toCharArray(),"3.....42.".toCharArray(),"...27.6..".toCharArray()};
        char[][] s3 = {"....5..1.".toCharArray(),".4.3.....".toCharArray(),".....3..1".toCharArray(),"8......2.".toCharArray(),"..2.7....".toCharArray(),".15......".toCharArray(),".....2...".toCharArray(),".2.9.....".toCharArray(),"..4......".toCharArray()};
        System.out.println(isValidSudoku(s1));
        System.out.println(isValidSudoku(s2));
        System.out.println(isValidSudoku(s3));
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean ret = true;
        //检查每行
        for(int i=0;i<9;i++){
            HashSet<Character> rowSet = new HashSet<Character>();
            for(int j= 0;j<9;j++){
                if(board[i][j] != '.'){
                    if(!rowSet.contains(board[i][j])){
                        rowSet.add(board[i][j]);
                    }
                    else{
                        ret = false;
                    }
                }
            }
        }
        //检查每列
        HashSet<Character>[] columnSetArray = new HashSet[9];
        for(int i=0; i<9; i++){
            columnSetArray[i] = new HashSet<Character>();
        }
        for(int i=0;i<9;i++){
            for(int j= 0;j<9;j++){
                if(board[i][j] != '.'){
                    if(!columnSetArray[j].contains(board[i][j])){
                        columnSetArray[j].add(board[i][j]);
                    }
                    else{
                        ret = false;
                    }
                }
            }
        }
        //检查每个子区域
        HashSet<Character>[] zoneSetArray = new HashSet[9];
        for(int i=0; i<9; i++){
            zoneSetArray[i] = new HashSet<Character>();
        }
        for(int i=0;i<9;i++){
            for(int j= 0;j<9;j++){
                int index = (i/3) * 3 + (j/3);
                if(board[i][j] != '.'){
                    if(!zoneSetArray[index].contains(board[i][j])){
                        zoneSetArray[index].add(board[i][j]);
                    }
                    else{
                        ret = false;
                    }
                }
            }
        }
        return ret;
    }
}
