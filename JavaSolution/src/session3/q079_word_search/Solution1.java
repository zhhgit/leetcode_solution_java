package session3.q079_word_search;

public class Solution1 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String[] arr = {"ABCCED","SEE","ABCB"};
        for(String word:arr){
            System.out.println(exist(board,word));
        }
    }

    private static boolean exist(char[][] board, String word) {
        int row = board.length;
        if(row == 0){
            return false;
        }
        int column = board[0].length;
        if(column == 0){
            return false;
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<column;j++){
                boolean[][] used = new boolean[row][column];
                if(backTracking(board,used,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backTracking(char[][] board,boolean[][] used,String word,int pos,int i,int j){
        int len = word.length();
        if(pos == len - 1){
            if(word.charAt(pos) == board[i][j]){
                return true;
            }
            else{
                return false;
            }
        }
        else if(word.charAt(pos) == board[i][j]){
            if(inRange(board,i-1,j) && !used[i-1][j]){
                used[i][j] = true;
                if(backTracking(board,used,word,pos + 1,i-1,j)){
                    return true;
                }
                used[i][j] = false;
            }
            if(inRange(board,i+1,j) && !used[i+1][j]){
                used[i][j] = true;
                if(backTracking(board,used,word,pos + 1,i+1,j)){
                    return true;
                };
                used[i][j] = false;
            }
            if(inRange(board,i,j-1) && !used[i][j-1]){
                used[i][j] = true;
                if(backTracking(board,used,word,pos + 1,i,j-1)){
                    return true;
                };
                used[i][j] = false;
            }
            if(inRange(board,i,j+1) && !used[i][j+1]){
                used[i][j] = true;
                if(backTracking(board,used,word,pos + 1,i,j+1)){
                    return true;
                };
                used[i][j] = false;
            }
        }
        return false;
    }

    private static boolean inRange(char[][] board,int i,int j){
        int row = board.length;
        int column = board[0].length;
        return i>=0 && j>=0 && i<row && j < column;
    }
}
