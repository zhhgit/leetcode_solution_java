package session1.q090_subsets_2;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        int n = nums.length;
        if(n==0){
            list.add(tempList);
        }
        else{
            backTracking(list,tempList,nums,0);
        }
        return list;
    }

    private static void backTracking(List<List<Integer>> list,LinkedList<Integer> tempList,int[] nums,int pos){
        int n = nums.length;
        if(pos==n){
            return;
        }
        else{
            if(!list.contains(tempList)){
                LinkedList insert = new LinkedList(tempList);
                list.add(insert);
            }
            for(int i=pos;i<n;i++){
                tempList.add(nums[i]);
                if(!list.contains(tempList)){
                    LinkedList insert = new LinkedList(tempList);
                    list.add(insert);
                    backTracking(list,tempList,nums,i+1);
                }
                if(tempList.size()>0){
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
}
