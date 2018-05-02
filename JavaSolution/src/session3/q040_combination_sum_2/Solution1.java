package session3.q040_combination_sum_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        backTracking(lists,tempList,candidates,target,0,0);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists,List<Integer> tempList,int[] candidates,int target,int tempSum,int pos){
        if(tempSum == target){
            List<Integer> addList = new LinkedList<>(tempList);
            if(!lists.contains(addList)){
                lists.add(addList);
            }
        }
        else if(tempSum > target){
            return;
        }
        else{
            for(int i = pos;i<candidates.length;i++){
                tempList.add(candidates[i]);
                backTracking(lists,tempList,candidates,target,tempSum + candidates[i],i+1);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
}
