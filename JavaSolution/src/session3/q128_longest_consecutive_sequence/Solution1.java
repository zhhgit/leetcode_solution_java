package session3.q128_longest_consecutive_sequence;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[][] arr = {{9,1,4,7,3,-1,0,5,8,-1,6},{100, 4, 200, 1, 3, 2},{0,3,4,5,6,9,11}};
        for (int[] nums:arr){
            System.out.println(longestConsecutive(nums));
        }
    }

    private static int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1){
            return len;
        }
        Arrays.sort(nums);
        int maxLen = 1;
        int[] ret = new int[len];
        for (int i = 0;i<len;i++){
            if (i == 0){
                ret[i] = 1;
            }
            else {
                if (nums[i] - nums[i - 1] == 1){
                    ret[i] = ret[i - 1] + 1;
                }
                else if (nums[i] == nums[i - 1]){
                    ret[i] = ret[i - 1];
                }
                else {
                    ret[i] = 1;
                }
            }
            maxLen = Math.max(maxLen,ret[i]);
        }
        return maxLen;
    }
}
