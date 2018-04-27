package session3.q033_search_in_rotated_sorted_array;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        int[] targets  = {2};
        for(int target:targets){
            System.out.println(search(arr,target));
        }
    }

    private static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
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
            else {
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;

                }
                else{
                    right = mid - 1;
                }
            }
        }
        if(left == right){
            if(nums[left] == target){
                return left;
            }
            else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }
}
