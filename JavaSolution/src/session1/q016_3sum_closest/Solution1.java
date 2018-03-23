package session1.q016_3sum_closest;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(arr,target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int dis = Math.abs(target-nums[0]-nums[1]-nums[nums.length-1]);
        int ret = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<nums.length-2;i++){
            int sum = target - nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right] == sum){
                    return target;
                }
                else if(nums[left]+nums[right] < sum){
                    if(Math.abs(sum-nums[left]-nums[right])<dis){
                        dis = Math.abs(sum-nums[left]-nums[right]);
                        ret = nums[i]+nums[left]+nums[right];
                    }
                    left++;
                }
                else{
                    if(Math.abs(sum-nums[left]-nums[right])<dis){
                        dis = Math.abs(sum-nums[left]-nums[right]);
                        ret = nums[i]+nums[left]+nums[right];
                    }
                    right--;
                }
            }
        }
        return ret;
    }
}
