package session3.q152_maximum_product_subarray;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{-4,-3,-2}};
        for (int[] nums:numsArr){
            System.out.println(maxProduct(nums));
        }
    }

    private static int maxProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        int len = nums.length;
        // min,max是每轮以nums[i]为结尾的最大、最小值
        for (int i = 1;i<len;i++){
            int lastMax = max;
            int lastMin = min;
            max = Math.max(nums[i],Math.max(nums[i] * lastMax,nums[i] * lastMin));
            min = Math.min(nums[i],Math.min(nums[i] * lastMax,nums[i] * lastMin));
            if (max > result){
                result = max;
            }
        }
        return result;
    }
}
