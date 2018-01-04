package q130_surrounded_regions;

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
        for(int i=0;i<columnLen;i++){
            backTracking(board,0,i);
            backTracking(board,rowLen-1,i);
        }
        for(int i=0;i<rowLen;i++){
            backTracking(board,i,0);
            backTracking(board,i,columnLen-1);
        }
        changeAll(board);
    }

    //检验(x,y)位置，并递归其四周
    private static void backTracking(char[][] board,int x,int y){
        int rowLen = board.length;
        int columnLen = board[0].length;
        if(x>=0 && y>=0 && x<rowLen && y<columnLen){
            if(board[x][y] == 'O'){
                board[x][y] = '*';
                backTracking(board,x-1,y);
                backTracking(board,x+1,y);
                backTracking(board,x,y-1);
                backTracking(board,x,y+1);
            }
        }
    }

    private static void changeAll(char[][] board){
        int rowLen = board.length;
        int columnLen = board[0].length;
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<columnLen;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<columnLen;j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
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
