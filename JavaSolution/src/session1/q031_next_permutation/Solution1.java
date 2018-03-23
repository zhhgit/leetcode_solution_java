package session1.q031_next_permutation;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[][] arr = {{1,2,3},{3,2,1},{1,3,1,5}};
        for(int i=0;i<arr.length;i++){
            nextPermutation(arr[i]);
        }
    }

    private static void nextPermutation(int[] nums) {
        if(checkMax(nums)){
            Arrays.sort(nums);
        }
        else{
            int i=nums.length-2;
            while((i>=0)&&(nums[i]>=nums[i+1])){
                i--;
            }
            int changePos = i;
            for(int j=nums.length-1;j>changePos;j--){
                if(nums[j]>nums[changePos]){
                    int temp = nums[changePos];
                    nums[changePos] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
            Arrays.sort(nums,changePos+1,nums.length);
        }
    }

    private static boolean checkMax(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
