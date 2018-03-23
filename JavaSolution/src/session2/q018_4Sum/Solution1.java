package session2.q018_4Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        System.out.println(fourSum(nums,target));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        if(nums.length < 4){
            return lists;
        }
        for(int i=0;i<nums.length - 3;i++){
            for(int j=i+1;j<nums.length -2;j++)
            eachRound(nums,lists,i,j,target-nums[i] - nums[j]);
        }
        return lists;
    }

    private static void eachRound(int[] nums,List<List<Integer>> lists,int iPos,int jPos,int remain){
        int left = jPos + 1;
        int right = nums.length -1;
        while(left < right){
            if(nums[left] + nums[right] == remain){
                List<Integer> addList = new LinkedList<>();
                addList.add(nums[iPos]);
                addList.add(nums[jPos]);
                addList.add(nums[left]);
                addList.add(nums[right]);
                if(!lists.contains(addList)){
                    lists.add(addList);
                }
                left++;
                right--;
            }
            else if(nums[left] + nums[right] < remain){
                left++;
            }
            else{
                right--;
            }
        }
    }
}
