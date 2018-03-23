package session2.q153_find_minimum_in_rotated_sorted_array;

public class Solution1 {
    public static void main(String[] args){
        int[][] nums = {{1,2,3,4,5,6,7,8},{3,4,5,6,7,8,1,2},{6,7,8,1,2,3,4,5},{7,8,1,2,3,4,5,6}};
        for(int[] num:nums){
            System.out.println(findMin(num));
        }
    }

    private static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int middle = (left + right) / 2;
            if(nums[middle] == nums[left] || nums[middle] == nums[right]){
                break;
            }
            if(nums[middle] > nums[right]){
                left = middle;
            }
            else if(nums[middle] < nums[left]){
                right = middle;
            }
            else{
                return nums[0];
            }
        }
        return Math.min(nums[left],nums[right]);
    }
}
