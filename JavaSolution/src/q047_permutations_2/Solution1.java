package q047_permutations_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        if(nums.length == 0){
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        boolean[] useFlag = new boolean[nums.length];
        for(int i=0;i < nums.length;i++){
            useFlag[i] = false;
        }
        backTracking(nums,lists,tempList,useFlag);
        return lists;
    }

    private static void backTracking(int[] nums,List<List<Integer>> lists,List<Integer> tempList,boolean[] useFlag){
        if(tempList.size() == nums.length){
            List<Integer> addList = new LinkedList<>(tempList);
            lists.add(addList);
        }
        for(int i=0;i< nums.length;i++){
            if(useFlag[i] == true){
                continue;
            }
            //前一个要是没用过的，跳过才有意义。
            else if(i > 0 && nums[i] == nums[i-1] && (!useFlag[i-1])){
                continue;
            }
            else {
                tempList.add(nums[i]);
                useFlag[i] = true;
                backTracking(nums,lists,tempList,useFlag);
                tempList.remove(tempList.size() - 1);
                useFlag[i] = false;
            }
        }
    }
}
