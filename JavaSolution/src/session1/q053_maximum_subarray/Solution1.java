package session1.q053_maximum_subarray;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int maxRet = nums[0];
        int maxTemp = nums[0];
        for(int i=1;i<nums.length;i++){
            if(maxTemp<0){
                maxTemp = nums[i];
            }
            else{
                maxTemp += nums[i];
            }
            maxRet = Math.max(maxRet,maxTemp);
        }
        return maxRet;
    }
}
