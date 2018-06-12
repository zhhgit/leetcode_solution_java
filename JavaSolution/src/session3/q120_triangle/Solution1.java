package session3.q120_triangle;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[][] numArr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0;i<numArr.length;i++){
            List<Integer> addList = new LinkedList<>();
            for(int j = 0;j<numArr[i].length;j++){
                addList.add(numArr[i][j]);
            }
            lists.add(addList);
        }
        System.out.println(minimumTotal(lists));
    }

    private static int minVal;

    private static int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        if (level == 0){
            return 0;
        }
        if (level == 1){
            return triangle.get(0).get(0);
        }
        minVal = Integer.MAX_VALUE;
        backTracking(triangle,0,0,0);
        return minVal;
    }

    private static void backTracking(List<List<Integer>> triangle,int tempSum,int level, int pos){
        int totalLevel = triangle.size();
        if (totalLevel - 1 == level){
            minVal = Math.min(minVal,tempSum + triangle.get(level).get(pos));
        }
        else {
            backTracking(triangle,tempSum+triangle.get(level).get(pos), level + 1,pos);
            backTracking(triangle,tempSum+triangle.get(level).get(pos), level + 1,pos + 1);
        }
    }
}
