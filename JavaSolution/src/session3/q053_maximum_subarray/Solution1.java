package session3.q053_maximum_subarray;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-2,1,4,5,-2,-7,1};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxRet;
        int[] sumArr = new int[len];
        sumArr[0] = nums[0];
        maxRet = nums[0];
        for(int i = 1;i<len;i++){
            if(sumArr[i-1] < 0){
                sumArr[i] = nums[i];
            }
            else{
                sumArr[i] = sumArr[i-1] + nums[i];
            }
            maxRet = Math.max(maxRet,sumArr[i]);
        }
        return maxRet;
    }
}
