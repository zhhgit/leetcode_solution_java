package session2.q079_word_search;

public class Solution1 {
    public static void main(String[] args){
        char[][] board = {
                {'A','A'}};
        String[] words = {"AAA"};
        for(String word:words){
            System.out.println(exist(board,word));
        }
    }

    private static boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        if(rowLen == 0){
            return false;
        }
        int columnLen = board[0].length;
        if(columnLen == 0){
            return false;
        }
        if(word.length() > rowLen * columnLen){
            return false;
        }
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<columnLen;j++){
                boolean[][] used = new boolean[rowLen][columnLen];
                if(backTracking(board,word,0,used,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backTracking(char[][] board,String word,int wordPos,boolean[][] used,int x,int y){
        //超出范围false
        if(!inBoxRange(x,y,board)){
            return false;
        }
        //已使用过false
        else if(used[x][y]){
            return false;
        }
        //未使用过也不等false
        else if(word.charAt(wordPos) != board[x][y]){
            return false;
        }
        else if(wordPos >= word.length()-1){
            return true;
        }
        else{
            used[x][y] = true;
            boolean result =  backTracking(board,word,wordPos+1,used,x-1,y) ||
                    backTracking(board,word,wordPos+1,used,x+1,y) ||
                    backTracking(board,word,wordPos+1,used,x,y-1) ||
                    backTracking(board,word,wordPos+1,used,x,y+1);
            used[x][y] = false;
            return result;
        }
    }

    private static boolean inBoxRange(int x,int y,char[][] board){
        int rowLen = board.length;
        int columnLen = board[0].length;
        return (x >= 0 && x < rowLen && y >=0 && y < columnLen);
    }
}
