package session1.q040_combination_sum_2;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        LinkedList tempList = new LinkedList();
        Arrays.sort(candidates);
        backTracking(ret,tempList,candidates,0,target);
        return ret;
    }

    private static void backTracking(List<List<Integer>> list,LinkedList tempList,int[] candidates,int startPos,int target){
        if((target<candidates[0]) && (tempList.size()>0)){
            tempList.remove(tempList.size()-1);
        }
        else{
            for(int i=startPos;i<candidates.length;i++){
                if(target==candidates[i]){
                    tempList.add(candidates[i]);
                    LinkedList insertList = new LinkedList(tempList);
                    if(!list.contains(insertList)){
                        list.add(insertList);
                    }
                    tempList.remove(tempList.size()-1);
                }
                else{
                    tempList.add(candidates[i]);
                    backTracking(list,tempList,candidates,i+1,target-candidates[i]);
                }
            }
            if(tempList.size()>0){
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
