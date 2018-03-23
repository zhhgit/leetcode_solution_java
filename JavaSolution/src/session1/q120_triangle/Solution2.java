package session1.q120_triangle;

import java.util.*;

public class Solution2 {
    public static void main(String[] args){
        int[][] triangleArr = {{2}, {3,4}, {6,5,7}, {4,1,8,3}};
        List<List<Integer>> triangle = new LinkedList<>();
        for(int i=0;i<triangleArr.length;i++){
            List<Integer> level = new LinkedList<>();
            for(int j=0;j<triangleArr[i].length;j++){
                level.add(triangleArr[i][j]);
            }
            triangle.add(level);
        }
        System.out.println(minimumTotal(triangle));
    }

    private static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        else{
            int levels = triangle.size();
            int[] calArr = new int[levels];
            for(int i=0;i<levels;i++){
                calArr[i] = triangle.get(levels-1).get(i);
            }
            for(int i=levels-2;i>=0;i--){
                for(int j=0;j<=i;j++){
                    calArr[j] = triangle.get(i).get(j) + Math.min(calArr[j],calArr[j+1]);
                }
            }
            return calArr[0];
        }
    }
}
