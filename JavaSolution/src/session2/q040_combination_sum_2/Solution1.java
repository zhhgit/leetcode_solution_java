package session2.q040_combination_sum_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target)  {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new LinkedList<>();
        if(candidates.length == 0){
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        backTracking(candidates,lists,tempList,-1,0,target);
        return lists;
    }

    private static void backTracking(int[] candidates,List<List<Integer>> lists,List<Integer> tempList,int currPos,int tempSum,int target){
        if(tempSum > target){
            tempList.remove(tempList.size()-1);
            return;
        }
        if(tempSum == target){
            if(!lists.contains(tempList)){
                List<Integer> addList = new LinkedList<>(tempList);
                lists.add(addList);
            }
        }
        else{
            for(int i=currPos + 1;i<candidates.length;i++){
                tempList.add(candidates[i]);
                backTracking(candidates,lists,tempList,i,tempSum + candidates[i],target);
            }
        }
        if(tempList.size() > 0){
            tempList.remove(tempList.size() -1);
        }
    }
}
