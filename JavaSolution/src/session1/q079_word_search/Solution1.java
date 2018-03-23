package session1.q079_word_search;

public class Solution1 {
    public static void main(String[] args){
        char[][] board = {"ABC".toCharArray()};
        String[] words ={"D"};
        for(int i=0;i<words.length;i++){
            System.out.println(exist(board,words[i]));
        }
    }

    private static boolean exist(char[][] board, String word) {
        boolean ret = false;
        int row = board.length;
        if(row>0){
            int column = board[0].length;
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    if(backTracking(board,word,0,i,j)){
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }

    private static boolean backTracking(char[][] board,String word,int currPos,int rowIndex,int columnIndex){
        boolean ret = false;
        int row = board.length;
        int column = board[0].length;
        if(currPos>=word.length()){
            ret = true;
        }
        else if(rowIndex<0 || rowIndex>=row || columnIndex<0 || columnIndex>=column){
            return false;
        }
        else if(board[rowIndex][columnIndex]!=word.charAt(currPos)){
            return false;
        }
        else {
            //转换成非字母
            board[rowIndex][columnIndex] ^= 256;
            ret = backTracking(board, word, currPos + 1, rowIndex - 1, columnIndex)
                    || backTracking(board, word, currPos + 1, rowIndex + 1, columnIndex)
                    || backTracking(board, word, currPos + 1, rowIndex, columnIndex - 1)
                    || backTracking(board, word, currPos + 1, rowIndex, columnIndex + 1);
            //转换成原字母
            board[rowIndex][columnIndex] ^= 256;
        }
        return ret;
    }
}
