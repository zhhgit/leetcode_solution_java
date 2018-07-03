package session3.q137_single_number_2;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[][] arr = {{-2,-2,1,1,-3,1,-3,-3,-4,-2},{0,1,0,1,0,1,99},{2,2,3,2}};
        for(int[] nums:arr){
            System.out.println(singleNumber(nums));
        }
    }

    private static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int group = 0;
        while (group * 3 < len - 1){
            int first = nums[group * 3];
            int second = nums[group * 3 + 1];
            int third = nums[group * 3 + 2];
            if (first == second && first == third){
                group++;
            }
            else {
                return nums[group * 3];
            }
        }
        return nums[len - 1];
    }
}
