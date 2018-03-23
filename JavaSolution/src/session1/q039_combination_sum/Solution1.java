package session1.q039_combination_sum;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 6;
        System.out.println(combinationSum(candidates,target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        Arrays.sort(candidates);
        backTracking(list,tempList,candidates,0,target);
        return list;
    }

    private static void backTracking(List<List<Integer>> list,LinkedList<Integer> tempList,int[] candidates,int startPos,int target){
        if((target<candidates[startPos]) && (tempList.size()>0)){
            tempList.remove(tempList.size()-1);
        }
        else{
            for(int i=startPos;i<candidates.length;i++){
                if(target==candidates[i]){
                    tempList.add(candidates[i]);
                    LinkedList insertList = new LinkedList(tempList);
                    list.add(insertList);
                    tempList.remove(tempList.size()-1);
                }
                else{
                    tempList.add(candidates[i]);
                    backTracking(list,tempList,candidates,i,target-candidates[i]);
                }
            }
            if(tempList.size()>0){
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
