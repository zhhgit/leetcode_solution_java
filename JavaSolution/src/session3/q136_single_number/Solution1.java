package session3.q136_single_number;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{4,1,2,1,2},{2},{1,1,2,3,3}};
        for (int[] nums:numsArr){
            System.out.println(singleNumber(nums));
        }
    }

    private static int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i = 0;i<len / 2;i++){
            if (nums[i * 2] != nums[i * 2 + 1]){
                return nums[i * 2];
            }
        }
        return nums[len - 1];
    }
}
