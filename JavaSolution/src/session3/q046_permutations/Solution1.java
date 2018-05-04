package session3.q046_permutations;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new LinkedList<>();
        if(len == 0){
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        boolean[] used = new boolean[len];
        backTracking(lists,tempList,used,nums);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists,List<Integer> tempList,boolean[] used,int[] nums){
        int len = nums.length;
        if(tempList.size() == len){
            List<Integer> addList = new LinkedList<>(tempList);
            if(!lists.contains(addList)){
                lists.add(addList);
            }
        }
        else {
            for(int i = 0;i<len;i++){
                if(!used[i]){
                    tempList.add(nums[i]);
                    used[i] = true;
                    backTracking(lists,tempList,used,nums);
                    if(tempList.size() > 0){
                        tempList.remove(tempList.size() - 1);
                    }
                    used[i] = false;
                }
            }
        }
    }
}
