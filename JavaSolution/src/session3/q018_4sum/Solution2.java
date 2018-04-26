package session3.q018_4sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args){
        int[] nums = {1, 0, -1,0,2,-2};
        int target = 0;
        System.out.println(fourSum(nums,target));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        if(nums.length < 4){
            return lists;
        }
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-3;i++){
            for(int j = i+1;j<nums.length-2;j++){
                int remain = target - nums[i] - nums[j];
                eachRound(lists,nums,i,j,remain);
            }
        }
        return lists;
    }

    private static void eachRound(List<List<Integer>> lists,int[] nums,int iPos,int jPos,int remain){
        int left = jPos + 1;
        int right = nums.length-1;
        while (left < right){
            if(nums[left] + nums[right] == remain){
                List<Integer> addList = new LinkedList<>(Arrays.asList(nums[iPos],nums[jPos],nums[left],nums[right]));
                if(!lists.contains(addList)){
                    lists.add(addList);
                }
                left++;
                right--;
            }
            else if(nums[left] + nums[right] < remain){
                left++;
            }
            else {
                right--;
            }
        }
    }
}
