package q130_surrounded_regions;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args){
        char[][] board = {"XXXX".toCharArray(),"XOOX".toCharArray(),"XXOX".toCharArray(),"XOXX".toCharArray()};
        printCharMatrix(board);
        System.out.println("------------------------------------");
        solve(board);
        printCharMatrix(board);
    }

    private static void solve(char[][] board) {
        int rowLen = board.length;
        if(rowLen == 0){
            return;
        }
        int columnLen = board[0].length;
        if(columnLen == 0){
            return;
        }
    }

    private static void printCharMatrix(char[][] board){
        int row = board.length;
        int column = board[0].length;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<column;j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
