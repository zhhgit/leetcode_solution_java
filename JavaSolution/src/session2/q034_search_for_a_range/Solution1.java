package session2.q034_search_for_a_range;

import session2.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        PrintUtil.printNumArray(searchRange(nums,target));
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        if(nums.length == 0){
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int middle = (left + right) / 2;
            if(nums[middle] == target){
                ret = expandArr(nums,middle);
                return ret;
            }
            else if(nums[middle] < target){
                left = middle + 1;
            }
            else{
                right = middle -1;
            }
        }
        if(nums[left] == target){
            ret[0] = left;
            ret[1] = left;
        }
        else{
            ret[0] = -1;
            ret[1] = -1;
        }
        return ret;
    }

    private static int[] expandArr(int[] nums,int middle) {
        int[] ret = new int[2];
        int target = nums[middle];
        int i = middle;
        while(i>=0 && nums[i] == target){
            i--;
        }
        ret[0] = i + 1;
        i = middle;
        while(i<nums.length && nums[i] == target){
            i++;
        }
        ret[1] = i - 1;
        return ret;
    }
}
