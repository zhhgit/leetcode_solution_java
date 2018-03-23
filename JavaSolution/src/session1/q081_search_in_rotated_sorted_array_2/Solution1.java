package session1.q081_search_in_rotated_sorted_array_2;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,1,3};
        int target = 3;
        System.out.println(search(nums,target));
    }

    private static boolean search(int[] nums, int target) {
        boolean ret = false;
        if(nums.length>=1){
            int left = 0;
            int right = nums.length-1;
            int mid;
            while(left<right){
                mid = (left+right+1)/2;
                if(nums[mid] == target){
                    return true;
                }
                else if(nums[mid]>nums[right]){
                    if(target>=nums[left] && target<nums[mid]){
                        right = mid;
                    }
                    else{
                        left = mid;
                    }
                }
                else if(nums[mid]<nums[right]){
                    if(target<=nums[right] && target>nums[mid]){
                        left = mid;
                    }
                    else{
                        right = mid;
                    }
                }
                else{
                    right--;
                }
            }
            if(left==right && nums[left]==target){
                return true;
            }
        }
        return ret;
    }
}
