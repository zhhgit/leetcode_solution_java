package q130_surrounded_regions;

import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        char[][] board = {"xxxx".toCharArray(),"xoox".toCharArray(),"xxox".toCharArray(),"xoxx".toCharArray()};
        solve(board);
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

    private static void solve(char[][] board) {
        int rowLen = board.length;
        if(rowLen == 0){
            return;
        }
        int columnLen = board[0].length;
        if(columnLen == 0){
            return;
        }
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<columnLen;j++){
                if(board[i][j] == 'o'&& i != 0 && i != rowLen-1 && j != 0 && j!= columnLen - 1){

                }
            }
        }
    }

    private static void backTracking(char[][] board, List<Position> neighbourList){

    }

    private static class Position{
        int x;
        int y;
        public Position(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean allValid(char[][] board,List<Position> neighbourList){
        return false;
    }
}
