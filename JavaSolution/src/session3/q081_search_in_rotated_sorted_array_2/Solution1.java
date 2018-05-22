package session3.q081_search_in_rotated_sorted_array_2;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,3,5};
        int[] targetArr = {1};
        for(int target:targetArr){
            System.out.println(search(nums,target));
        }
    }

    private static boolean search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return false;
        }
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return true;
            }
            //转轴在右侧，左侧连续递增
            else if(nums[mid] > nums[right]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            //转轴在左侧，右侧连续递增
            else if(nums[mid] < nums[right]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            else {
                right--;
            }
        }
        if(left == right){
            if(nums[left] == target){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
