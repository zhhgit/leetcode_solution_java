package session1.q033_search_in_rotated_sorted_array;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        int[] targets = {4,0,9};
        for(int target:targets){
            System.out.println(search(arr,target));
        }
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<right){
            mid = (left+right+1)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid]>nums[right]){
                if(target<nums[mid] && target>=nums[left]){
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
            return left;
        }
        else{
            return -1;
        }
    }
}
