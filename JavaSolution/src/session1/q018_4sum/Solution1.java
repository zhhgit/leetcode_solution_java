package session1.q018_4sum;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {-3,-2,-1,-1,-1,0,0,0,1,2,3};
        int target = 0;
        System.out.println(fourSum(arr,target));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int left = j+1;
                int right = nums.length-1;
                int sum = target-nums[i]-nums[j];
                while(left<right){
                    if(nums[left] + nums[right] == sum){
                        if(!ret.contains(Arrays.asList(nums[i],nums[j],nums[left],nums[right]))){
                            ret.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        }
                        left++;
                        right--;
                    }
                    else if(nums[left] + nums[right] < sum){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return ret;
    }
}
