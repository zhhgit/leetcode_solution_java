package session3.q037_sudoku_solver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args){
        char[][] board = {
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray()
        };
        solveSudoku(board);
        print2DMatrix(board);
    }

    private static boolean findFlag = false;

    private static void solveSudoku(char[][] board) {
        List<Position> visitedPositions = new LinkedList<>();
        backTracking(board,visitedPositions);
    }

    private static void backTracking(char[][] board,List<Position> visitedPositions){
        if (!findFlag){
            Position emptyPosition = findEmpty(board);
            if (emptyPosition != null){
                int x = emptyPosition.x;
                int y = emptyPosition.y;
                List<Integer> possible = possibleDigit(board,emptyPosition);
                for (int digit:possible){
                    if (!findFlag){
                        board[x][y] = (char) (digit + '0');
                        visitedPositions.add(new Position(x,y));
                        backTracking(board,visitedPositions);
                        if (!findFlag){
                            if (visitedPositions.size() > 0){
                                visitedPositions.remove(visitedPositions.size() - 1);
                            }
                            board[x][y] = '.';
                        }
                    }
                }
            }
            else {
                findFlag = true;
            }
        }
    }

    private static List<Integer> possibleDigit(char[][] board, Position position){
        int rowLen = board.length;
        int columnLen = board[0].length;
        int x = position.x;
        int y = position.y;
        Set<Integer> showSet = new HashSet<>();
        // 行
        for (int i = 0;i<columnLen;i++){
            if (board[x][i] != '.'){
                showSet.add(board[x][i] - '0');
            }
        }
        // 列
        for (int i = 0;i<rowLen;i++){
            if (board[i][y] != '.'){
                showSet.add(board[i][y] - '0');
            }
        }
        // 3*3
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX;i<startX + 3;i++){
            for (int j = startY;j<startY + 3;j++){
                if (board[i][j] != '.'){
                    showSet.add(board[i][j] - '0');
                }
            }
        }
        List<Integer> possible = new LinkedList<>();
        for (int i = 1;i<=9;i++){
            if (!showSet.contains(i)){
                possible.add(i);
            }
        }
        return possible;
    }

    private static Position findEmpty(char[][] board){
        int rowLen = board.length;
        int columnLen = board[0].length;
        for (int i = 0;i<rowLen;i++){
            for (int j = 0;j<columnLen;j++){
                if (board[i][j] == '.'){
                    return (new Position(i,j));
                }
            }
        }
        return null;
    }
    
    private static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print2DMatrix(char[][] matrix){
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        for (int i = 0;i<rowLen;i++){
            for (int j = 0;j<columnLen;j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
