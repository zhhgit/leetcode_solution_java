package session3.q027_remove_element;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums,val));
        PrintUtil.printNumArray(nums);
    }

    private static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
