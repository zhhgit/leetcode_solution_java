package session3.q041_first_missing_positive;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[][] arr = {{3,4,-1,1},{7,8,9,11,12},{},{0,2,2,1,1},{0,1,2,4},{1},{2,1},{1,2,0}};
        for (int[] nums:arr){
            System.out.println(firstMissingPositive(nums));
        }
    }

    private static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len == 0){
            return 1;
        }
        int i = 0;
        // 跳过非负数
        while (i < len && nums[i] <= 0){
            i++;
        }
        // 如果已经到最后
        if (i == len){
            return 1;
        }
        // 正常情况是应该为1
        if (nums[i] == 1){
            i++;
            while ((i<len) && (nums[i] == nums[i-1] || nums[i] - nums[i-1] == 1)){
                i++;
            }
            if (i == len){
                return nums[len - 1] + 1;
            }
            else {
                return nums[i - 1] + 1;
            }
        }
        else{
            return 1;
        }
    }
}
