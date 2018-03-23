package session2.q090_subsets_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(nums,lists,tempList,used,0);
        return lists;
    }

    private static void backTracking(int[] nums,List<List<Integer>> lists,List<Integer> tempList,boolean[] used,int pos){
        List<Integer> addList = new LinkedList<>(tempList);
        if(!lists.contains(addList)){
            lists.add(addList);
        }
        for(int i=pos;i<nums.length;i++){
            if(!used[i]){
                used[i] = true;
                tempList.add(nums[i]);
                backTracking(nums,lists,tempList,used,i+1);
                tempList.remove(tempList.size() -1);
                used[i] = false;
            }
        }
    }
}
