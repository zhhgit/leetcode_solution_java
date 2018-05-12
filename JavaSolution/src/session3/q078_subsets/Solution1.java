package session3.q078_subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        int len = nums.length;
        if(len == 0){
            lists.add(new LinkedList<>());
            return lists;
        }
        boolean[] used = new boolean[len];
        List<Integer> tempList = new LinkedList<>();
        backTracking(nums,lists,tempList,0);
        return lists;
    }

    private static void backTracking(int[] nums,List<List<Integer>> lists,List<Integer> tempList,int pos){
        int len = nums.length;
        List<Integer> addList = new LinkedList<>(tempList);
        if(!lists.contains(addList)){
            lists.add(addList);
        }
        for(int i = pos;i<len;i++){
            tempList.add(nums[i]);
            backTracking(nums,lists,tempList,i + 1);
            if(tempList.size() > 0){
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
