package session2.q152_maximum_product_subarray;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int result = nums[0];
        //max和min并不是全局的最大最小，而是以num[i]为结尾的连续的subarray的最大最小值。
        int max = nums[0];
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            int lastMax = max;
            int lastMin = min;
            //更新过程中要么与前面的结合（可以结合，因为前面的是以最后一个数为结尾的），要么以nums[i]为新的开头
            max = Math.max(Math.max(lastMax * nums[i],lastMin * nums[i]),nums[i]);
            min = Math.min(Math.min(lastMax * nums[i],lastMin * nums[i]),nums[i]);
            if(max > result){
                result = max;
            }
        }
        return result;
    }
}
