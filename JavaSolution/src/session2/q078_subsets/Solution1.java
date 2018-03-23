package session2.q078_subsets;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if(nums.length == 0){
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(nums,lists,tempList,used);
        return lists;
    }

    private static void backTracking(int[] nums,List<List<Integer>> lists,List<Integer> tempList, boolean[] used){
        List<Integer> addList = new LinkedList<>(tempList);
        lists.add(addList);
        if(tempList.size() < nums.length){
            int prev;
            if(tempList.size() > 0){
                prev = tempList.get(tempList.size()-1);
            }
            else{
                prev = Integer.MIN_VALUE;
            }
            for(int i = 0;i<nums.length;i++){

                if(nums[i]>prev && !used[i]){
                    tempList.add(nums[i]);
                    used[i] = true;
                    backTracking(nums,lists,tempList,used);
                    tempList.remove(tempList.size()-1);
                    used[i] = false;
                }
            }
        }
    }
}
