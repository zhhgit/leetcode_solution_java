package session2.q283_move_zeroes;

import session2.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {0,1,3,12,0,1};
        moveZeroes(nums);
        PrintUtil.printNumArray(nums);
    }

    private static void moveZeroes(int[] nums) {
        int len = nums.length;
        int pos = 0;
        for(int i = 0;i<len;i++){
            if(nums[i] != 0){
                nums[pos++] = nums[i];
            }
        }
        while (pos < len){
            nums[pos++] = 0;
        }
    }
}
