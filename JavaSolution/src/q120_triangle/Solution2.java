package q120_triangle;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args){
        List<List<Integer>> lists = getLists();
        System.out.println(minimumTotal(lists));
    }

    private static List<List<Integer>> getLists(){
        List<List<Integer>> lists = new LinkedList<>();
        int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
        for(int[] arr:triangle){
            List<Integer> addList = new LinkedList<>();
            for(int i = 0;i<arr.length;i++){
                addList.add(arr[i]);
            }
            lists.add(addList);
        }
        return lists;
    }

    private static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }
        int totalLevel = triangle.size();
        for(int i = totalLevel - 2;i>=0;i--){
            List<Integer> currLevel = triangle.get(i);
            for(int j = 0;j <= i;j++){
                currLevel.set(j,currLevel.get(j) + Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
