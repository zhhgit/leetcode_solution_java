package session1.q078_subsets;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        backTracking(list,tempList,0,nums);
        return list;
    }

    private static void backTracking(List<List<Integer>> list,LinkedList<Integer> tempList,int startPos,int[] nums){
        LinkedList<Integer> insert = new LinkedList<>(tempList);
        list.add(insert);
        if(startPos>nums.length-1){
            tempList.remove(tempList.size()-1);
            return;
        }
        for(int i=startPos;i<nums.length;i++){
            tempList.add(nums[i]);
            backTracking(list,tempList,i+1,nums);
        }
        if(tempList.size()>0){
            tempList.remove(tempList.size()-1);
        }
    }
}
