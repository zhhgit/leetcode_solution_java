package session2.q189_rotate_array;

import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 0;
        rotate(nums,k);
        PrintUtil.printNumArray(nums);
    }

    private static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] temp = new int[k];
        for(int i=0;i<k;i++){
            temp[i] = nums[len - k +i];
        }
        for(int i=len - k -1;i>=0;i--){
            nums[i+k] = nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i] = temp[i];
        }
    }
}
