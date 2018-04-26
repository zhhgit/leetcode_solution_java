package session3.q016_3sum_closest;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }

    private static int result;
    private static int distance = Integer.MAX_VALUE;

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i<len-2;i++){
            twoSumWithRemain(nums,i + 1,target-nums[i]);
        }
        return result;
    }

    private static void twoSumWithRemain(int[] nums,int pos,int remain){
        int len = nums.length;
        int left = pos;
        int right = len -1;
        while (left < right){
            int temp = nums[left] + nums[right];
            int tempDistance = Math.abs(temp - remain);
            if(tempDistance < distance){
                distance = tempDistance;
                result = temp + nums[pos-1];
            }
            if(tempDistance == 0){
                break;
            }
            else if(remain > temp){
                left++;
            }
            else {
                right--;
            }
        }
    }
}
