package algorithm1.array;

import algorithm1.common.PrintUtil;

public class RemoveDuplicates {

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        PrintUtil.printNumArray(nums);
        System.out.println(removeDuplicates(nums));
        PrintUtil.printNumArray(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return len;
        }
        int pos = 1;
        for (int i = 1; i < len; i++){
            if (nums[i] != nums[i - 1]){
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}