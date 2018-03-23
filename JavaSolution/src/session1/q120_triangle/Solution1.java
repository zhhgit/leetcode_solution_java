package session1.q120_triangle;

import java.util.*;

public class Solution1 {
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
            return backTracking(triangle,0,0);
        }
    }

    private static int backTracking(List<List<Integer>> triangle,int level,int pos){
        if(level == triangle.size()-1){
            return triangle.get(level).get(pos);
        }
        else{
            return triangle.get(level).get(pos) + Math.min(backTracking(triangle,level+1,pos),backTracking(triangle,level+1,pos+1));
        }
    }
}
