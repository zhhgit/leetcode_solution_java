package session3.q026_remove_duplicates_from_sorted_array;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,2,4,4,5,6,7};
        System.out.println(removeDuplicates(arr));
        PrintUtil.printNumArray(arr);
    }

    private static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1){
            return len;
        }
        int index = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
