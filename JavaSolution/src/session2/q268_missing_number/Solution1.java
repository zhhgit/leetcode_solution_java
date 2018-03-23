package session2.q268_missing_number;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {0};
        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        while (i < len && i == nums[i]){
            i++;
        }
        return i;
    }
}
