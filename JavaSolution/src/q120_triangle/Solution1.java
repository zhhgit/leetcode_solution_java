package q120_triangle;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
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

    private static int minSum;

    private static int minimumTotal(List<List<Integer>> triangle) {
        int totalLevel = triangle.size();
        if(totalLevel == 0){
            return 0;
        }
        List<Integer> tempList = new LinkedList<>();
        minSum = Integer.MAX_VALUE;
        tempList.add(triangle.get(0).get(0));
        backTracking(triangle,tempList,0,triangle.get(0).get(0));
        return minSum;
    }

    private static void backTracking(List<List<Integer>> triangle,List<Integer> tempList,int lastPos,int tempSum){
        int totalLevel = triangle.size();
        int currLevel = tempList.size();
        //已经到最底端
        if(currLevel == totalLevel){
            minSum = Math.min(minSum,tempSum);
        }
        else{
            for(int i = lastPos;i<=lastPos+1;i++){
                int element = triangle.get(currLevel).get(i);
                tempList.add(element);
                backTracking(triangle,tempList,i,tempSum + element);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
