package session3.q153_find_minimum_in_rotated_sorted_array;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{3,4,5,1,2},{4,5,6,7,0,1,2}};
        for (int[] nums:numsArr){
            System.out.println(findMin(nums));
        }
    }

    private static int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = (left + right) / 2;
            // 左侧单调增，转轴在右侧，最小值在右侧
            if (nums[mid] > nums[right] && mid != left){
                left = mid;
            }
            // 右侧单调增，转轴在左侧，最小值在左侧
            else if (nums[mid] < nums[left] && mid != right) {
                right = mid;
            }
            else {
                return Math.min(nums[left],nums[right]);
            }
        }
        return nums[left];
    }
}
