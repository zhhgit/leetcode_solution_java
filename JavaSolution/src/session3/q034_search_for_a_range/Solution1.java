package session3.q034_search_for_a_range;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int[] targets = {5,6,8,11};
        for(int target:targets){
            PrintUtil.printNumArray(searchRange(nums,target));
        }
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] ret = {-1,-1};
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(target == nums[mid]){
                return extendRange(nums,mid,target);
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(left == right){
            if(nums[left] == target){
                ret[0] = left;
                ret[1] = left;
                return ret;
            }
            else{
                return ret;
            }
        }
        else{
            return ret;
        }
    }

    private static int[] extendRange(int[] nums,int pos,int target){
        int[] ret = new int[2];
        int i = pos;
        while ((i-1)>=0 && nums[i-1] == target){
            i--;
        }
        ret[0] = i;
        while ((i+1)<nums.length && nums[i+1] == target){
            i++;
        }
        ret[1] = i;
        return ret;
    }
}
