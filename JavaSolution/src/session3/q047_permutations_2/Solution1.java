package session3.q047_permutations_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,1,2,2,3};
        System.out.println(permuteUnique(nums));
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> tempList = new LinkedList<>();
        backTracking(lists,tempList,nums,visited);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists,List<Integer> tempList,int[] nums,boolean[] visited){
        int len = nums.length;
        if(tempList.size() == len){
            List<Integer> addList = new LinkedList<>(tempList);
            if(!lists.contains(addList)){
                lists.add(addList);
            }
        }
        else{
            for(int i=0;i<len;i++){
                if(!visited[i]){
                    tempList.add(nums[i]);
                    visited[i] = true;
                    backTracking(lists,tempList,nums,visited);
                    if(tempList.size() > 0){
                        tempList.remove(tempList.size()-1);
                    }
                    visited[i] = false;
                }
            }
        }
    }
}
