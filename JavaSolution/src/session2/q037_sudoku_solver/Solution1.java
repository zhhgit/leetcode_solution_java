package session2.q037_sudoku_solver;

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

    private static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        int rowLen = board.length;
        int columnLen = board[0].length;
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<columnLen;j++){
                if(board[i][j] == '.'){
                    for(char c = '1';c <= '9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int x, int y,char c){
        //row and column
        for(int i = 0;i<9;i++){
            if(board[x][i] != '.' && y != i){
                if(c == board[x][i]){
                    return false;
                }
            }
            if(board[i][y] != '.' && x != i){
                if(c == board[i][y]){
                    return false;
                }
            }
        }
        //zone
        int posX = (x / 3) * 3;
        int posY = (y / 3) * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[posX + i][posY + j] != '.' && !((posX + i == x) && (posY + j == y))) {
                    if(c == board[posX + i][posY + j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void print2DMatrix(char[][] matrix){
        int row = matrix.length;
        int column = 0;
        if(row > 0){
            column = matrix[0].length;
        }
        else{
            return;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j< column;j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
