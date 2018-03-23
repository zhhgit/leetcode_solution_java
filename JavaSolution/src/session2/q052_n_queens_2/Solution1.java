package session2.q052_n_queens_2;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args){
        int n = 4;
        System.out.println(totalNQueens(n));
    }

    private static int totalNQueens(int n) {
        List<List<String>> lists = new LinkedList<>();
        if(n<=0){
            return 0;
        }
        char[][] board = new char[n][n];
        setPointAll(board);
        List<Position> tempList = new LinkedList<>();
        backTracking(lists,board,tempList);
        return lists.size();
    }

    private static class Position{
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void setPointAll(char[][] board){
        int n = board.length;
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
    }

    private static void backTracking(List<List<String>> lists,char[][] board,List<Position> tempList){
        int n = board.length;
        if(tempList.size() == n){
            addNewSolution(lists,board);
        }
        else{
            //已经有几行了
            int size = tempList.size();
            for(int j=0;j<n;j++){
                if(validPlace(tempList,size,j)){
                    board[size][j] = 'Q';
                    tempList.add(new Position(size,j));
                    backTracking(lists,board,tempList);
                    if(tempList.size() >0){
                        tempList.remove(tempList.size()-1);
                    }
                    board[size][j] = '.';
                }
            }
        }
    }

    private static void addNewSolution(List<List<String>> lists,char[][] board){
        List<String> list = new LinkedList<>();
        int n = board.length;
        for(int i = 0;i<n;i++){
            list.add(String.valueOf(board[i]));
        }
        if(!lists.contains(list)){
            lists.add(list);
        }
    }

    private static boolean validPlace(List<Position> tempList, int x, int y){
        for(Position pos:tempList){
            if(pos.x == x || pos.y == y || Math.abs(pos.x - x) == Math.abs(pos.y - y)){
                return false;
            }
        }
        return true;
    }
}
