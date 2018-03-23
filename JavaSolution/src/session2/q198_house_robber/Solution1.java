package session2.q198_house_robber;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {3,5,6,7,2,1};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[1],nums[0]);
        }
        int[] store = new int[len];
        store[len -1] = nums[len -1];
        store[len -2] = Math.max(nums[len -1],nums[len - 2]);
        for(int i=len-3;i>=0;i--){
            store[i] = Math.max(nums[i] + store[i + 2],store[i + 1]);
        }
        return store[0];
    }
}
