package session2.q016_3Sum_closest;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }

    private static int sum;

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        sum = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){
            while (inRange(nums,i) && inRange(nums,i-1) && nums[i] == nums[i-1]){
                i++;
            }
            eachRound(nums,target,i,target-nums[i]);
        }
        return sum;
    }

    private static boolean inRange(int[] nums,int pos){
        return pos>=0 && pos< nums.length-2;
    }

    private static void eachRound(int[] nums,int target,int pos,int remain){
        if(sum == target){
            return;
        }
        int left = pos+1;
        int right = nums.length-1;
        while(left < right){
            int tempTwoSum = nums[left] + nums[right];
            if(Math.abs(tempTwoSum + nums[pos] -target) < Math.abs(sum -target) ){
                sum = tempTwoSum + nums[pos];
            }
            if(remain == tempTwoSum){
                sum = target;
                break;
            }
            if(remain > nums[left] + nums[right]){
                left++;
            }
            else if(remain < nums[left] + nums[right]){
                right--;
            }
        }
    }
}
