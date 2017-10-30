package q053_maximum_subarray;

/**
 * Created by zhanghao1 on 2017/10/30.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int retMax = sums[0];
        for(int i = 1;i<nums.length;i++){
            if(sums[i-1] < 0){
                sums[i] = nums[i];
            }
            else{
                sums[i] = sums[i-1] + nums[i];
            }
            retMax = Math.max(retMax,sums[i]);
        }
        return retMax;
    }
}
