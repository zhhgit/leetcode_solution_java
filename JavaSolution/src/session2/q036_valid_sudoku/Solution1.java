package session2.q036_valid_sudoku;

public class Solution1 {
    public static void main(String[] args){
        char[][] board = {".87654321".toCharArray(),"2........".toCharArray(),"3........".toCharArray(),"4........".toCharArray(),"5........".toCharArray(),"6........".toCharArray(),"7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()};
        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board) {
        int len = board.length;
        //验证行
        for(int i = 0;i<len;i++){
            if(!checkEach(board[i])){
                return false;
            }
        }
        //验证列
        for(int i = 0;i<len;i++){
            if(!checkEach(constructColumn(board,i,len))){
                return false;
            }
        }
        //验证子区域
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!checkEach(constructZone(board,i,j))){
                    return false;
                }
            }
        }


        return true;
    }

    private static boolean checkEach(char[] each){
        int len = each.length;
        boolean[] used = new boolean[len];
        for(int i=0;i<len;i++){
            if(each[i] != '.'){
                if(!used[each[i]-'0'-1]){
                    used[each[i]-'0'-1] = true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    private static char[] constructColumn(char[][] board,int index,int len){
        char[] ret = new char[len];
        for(int i=0;i<len;i++){
            ret[i] = board[i][index];
        }
        return ret;
    }

    private static char[] constructZone(char[][] board,int xIndex,int yIndex){
        char[] ret = new char[board.length];
        int retIndex = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ret[retIndex++] = board[xIndex*3+i][yIndex*3+j];
            }
        }
        return ret;
    }
}
