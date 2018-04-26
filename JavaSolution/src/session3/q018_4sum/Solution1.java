package session3.q018_4sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1, 0, -1,0,2,-2};
        int target = 0;
        System.out.println(fourSum(nums,target));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        if(nums.length == 0){
            return lists;
        }
        Arrays.sort(nums);
        List<Integer> tempList = new LinkedList<>();
        backTracking(lists,tempList,0,nums,0,target);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists,List<Integer> tempList,int pos,int[] nums,int tempSum,int target){
        if(tempList.size() == 4){
            if(tempSum == target){
                List<Integer> addList = new LinkedList<>(tempList);
                if(!lists.contains(addList)){
                    lists.add(addList);
                }
            }
        }
        else {
            for(int i = pos;i<nums.length;i++){
                tempList.add(nums[i]);
                //特别注意这里的第三个参数，不是pos+1,而是i+1
                backTracking(lists,tempList,i+1,nums,tempSum + nums[i],target);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
}
