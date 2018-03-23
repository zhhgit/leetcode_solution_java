package session1.q015_3sum;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {0,0,0};
        System.out.println(threeSum(arr));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if((i==0)||((i>0)&&(nums[i]!=nums[i-1]))){
                int left = i+1;
                int right = nums.length-1;
                int sum = 0-nums[i];
                while(left<right){
                    if(nums[left] + nums[right] == sum){
                        ret.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while((left+1<nums.length)&&(nums[left+1]==nums[left])){
                            left++;
                        }
                        while((right-1>=0)&&(nums[right-1]==nums[right])){
                            right--;
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
