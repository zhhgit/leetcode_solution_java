package session3.q052_n_queens_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 4;
        System.out.println(totalNQueens(n));
    }

    private static int totalNQueens(int n) {
        List<List<Position>> result = new LinkedList<>();
        List<Position> tempList = new LinkedList<>();
        backTracking(result,n,tempList);
        return result.size();
    }

    private static void backTracking(List<List<Position>> result,int n,List<Position> tempList){
        if (tempList.size() == n){
            List<Position> addList = new ArrayList<>(tempList);
            result.add(addList);
        }
        else {
            int row = tempList.size();
            for (int i = 0;i<n;i++){
                if (isValid(tempList,row,i)){
                    Position p = new Position(row,i);
                    tempList.add(p);
                    backTracking(result,n,tempList);
                    if (tempList.size() > 0){
                        tempList.remove(tempList.size() - 1);
                    }
                }
            }
        }
    }

    private static class Position{
        int x;
        int y;
        public Position(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isValid(List<Position> tempList, int x, int y){
        for (Position p:tempList){
            // 验证行
            if (p.x == x){
                return false;
            }
            // 验证列
            if (p.y == y){
                return false;
            }
            // 验证对角
            if (Math.abs(p.x - x) == Math.abs(p.y - y)){
                return false;
            }
        }
        return true;
    }
}
