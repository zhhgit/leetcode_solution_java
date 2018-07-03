package session3.q051_n_queens;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        printResult(result);
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        List<Position> tempList = new LinkedList<>();
        backTracking(result,n,tempList);
        return result;
    }

    private static void backTracking(List<List<String>> result,int n,List<Position> tempList){
        if (tempList.size() == n){
            result.add(positionListToResult(tempList));
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

    private static boolean isValid(List<Position> tempList,int x,int y){
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

    private static List<String> positionListToResult(List<Position> positionList){
        int n = positionList.size();
        List<String> ret = new LinkedList<>();
        for (Position p:positionList){
            int y = p.y;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0;i<n;i++){
                if (y == i){
                    stringBuilder.append("Q");
                }
                else{
                    stringBuilder.append(".");
                }
            }
            ret.add(stringBuilder.toString());
        }
        return ret;
    }

    private static void printResult(List<List<String>> result){
        int len = result.size();
        for (int i = 0;i<len;i++){
            List<String> oneResult = result.get(i);
            printOneResult(oneResult);
            System.out.println("--------------------------");
        }
    }

    private static void printOneResult(List<String> oneResult){
        for (int i = 0;i<oneResult.size();i++){
            char[] line = oneResult.get(i).toCharArray();
            for (int j = 0;j<line.length;j++){
                System.out.print(line[j]);
            }
            System.out.println();
        }
    }
}
