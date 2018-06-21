package session3.q130_surrounded_regions;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        char[][] board = {"OO".toCharArray(),"OO".toCharArray()};
        printCharMatrix(board);
        System.out.println("-----------------------");
        solve(board);
        printCharMatrix(board);
    }

    private static void solve(char[][] board) {
        int row = board.length;
        if (row == 0){
            return;
        }
        int column = board[0].length;
        if (column == 0){
            return;
        }
        for (int i = 0;i<row;i++){
            for (int j = 0;j<column;j++){
                if (i == 0 || i == row - 1 || j == 0 || j == column - 1){
                    if (board[i][j] == 'O'){
                        boolean[][] visited = new boolean[row][column];
                        convert(board,i,j,visited);
                    }
                }
            }
        }
        for (int i = 0;i<row;i++){
            for (int j = 0;j<column;j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0;i<row;i++){
            for (int j = 0;j<column;j++){
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void convert(char[][] board,int i,int j,boolean[][] visited){
        board[i][j] = 'A';
        visited[i][j] = true;
        if (inBoardRange(board,i-1,j) && !visited[i-1][j] && board[i-1][j] == 'O'){
            convert(board,i-1,j,visited);
        }
        if (inBoardRange(board,i+1,j) && !visited[i+1][j] && board[i+1][j] == 'O'){
            convert(board,i+1,j,visited);
        }
        if (inBoardRange(board,i,j-1) && !visited[i][j-1] && board[i][j-1] == 'O'){
            convert(board,i,j-1,visited);
        }
        if (inBoardRange(board,i,j+1) && !visited[i][j+1] && board[i][j+1] == 'O'){
            convert(board,i,j+1,visited);
        }
    }

    private static boolean inBoardRange(char[][] board,int i,int j){
        int row = board.length;
        int column = board[0].length;
        return i>=0 && i<row && j >=0 && j < column;
    }

    private static void printCharMatrix(char[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0;i<row;i++){
            for (int j = 0;j<column;j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
