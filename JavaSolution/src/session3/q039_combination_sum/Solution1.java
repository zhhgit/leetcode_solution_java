package session3.q039_combination_sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates,target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new LinkedList<>();
        if(candidates.length == 0){
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        backTracking(lists,tempList,candidates,target,0,0);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists,List<Integer> tempList,int[] candidates,int target,int tempSum,int pos){
        if(target == tempSum){
            List<Integer> addList = new LinkedList<>(tempList);
            if(!lists.contains(addList)){
                lists.add(addList);
            }
        }
        else if(tempSum > target){
            return;
        }
        else {
            for(int i = pos;i<candidates.length;i++){
                tempList.add(candidates[i]);
                backTracking(lists,tempList,candidates,target,tempSum + candidates[i],i);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
