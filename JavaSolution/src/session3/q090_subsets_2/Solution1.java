package session3.q090_subsets_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {4,4,4,1,4};
        System.out.println(subsetsWithDup(nums));
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> lists = new LinkedList<>();
        if(len == 0){
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        backTracking(lists,tempList,nums,0);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists,List<Integer> tempList,int[] nums,int pos){
        List<Integer> addList = new LinkedList<>(tempList);
        if(!lists.contains(addList)){
            lists.add(addList);
        }
        for(int i=pos;i<nums.length;i++){
            tempList.add(nums[i]);
            backTracking(lists,tempList,nums,i+1);
            if(tempList.size() > 0){
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
