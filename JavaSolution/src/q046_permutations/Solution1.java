package q046_permutations;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if(nums.length == 0){
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        boolean[] useFlag = new boolean[nums.length];
        for(int i=0;i < nums.length;i++){
            useFlag[i] = false;
        }
        backTracking(nums,lists,tempList,useFlag,-1);
        return lists;
    }

    private static void backTracking(int[] nums,List<List<Integer>> lists,List<Integer> tempList,boolean[] useFlag,int pos){
        if(tempList.size() == nums.length){
            List<Integer> addList = new LinkedList<>(tempList);
            lists.add(addList);
            tempList.remove(tempList.size() - 1);
            useFlag[pos] = false;
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(useFlag[i] == false){
                    tempList.add(nums[i]);
                    useFlag[i] = true;
                    backTracking(nums,lists,tempList,useFlag,i);
                }
            }
            if(tempList.size() > 0){
                tempList.remove(tempList.size() - 1);
            }
            if(pos >= 0 && pos < nums.length){
                useFlag[pos] = false;
            }
        }
    }
}
