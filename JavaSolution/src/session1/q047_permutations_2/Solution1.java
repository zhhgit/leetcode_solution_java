package session1.q047_permutations_2;

import java.util.*;

public class Solution1 {
    public static void  main(String[] args){
        int[] nums = {1,1,0,0,1,-1,-1,1};
        System.out.println(permuteUnique(nums));
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        boolean[] used = new boolean[len];
        backTracking(list,tempList,nums,used);
        return list;
    }

    private static void backTracking(List<List<Integer>> list,LinkedList<Integer> tempList,int[] nums,boolean[] used){
        if(tempList.size()==nums.length){
            LinkedList<Integer> insert = new LinkedList<>(tempList);
            list.add(insert);
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(used[i]){
                    continue;
                }
                else if((i>0) && (nums[i]==nums[i-1]) && (!used[i-1])){
                    continue;
                }
                else{
                    tempList.add(nums[i]);
                    used[i] = true;
                    backTracking(list,tempList,nums,used);
                    tempList.remove(tempList.size()-1);
                    used[i] = false;
                }
            }
        }
    }
}
