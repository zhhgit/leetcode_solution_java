package session3.q154_find_minimum_in_rotated_sorted_array_2;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{10,1,10,10,10},{1,3,5},{2,2,2,0,1},{2,2,2,0,1,2},{2,2,2,0,1},{2,0,1,2},{0,1,2,2,2}};
        for (int[] nums : numsArr){
            System.out.println(findMin(nums));
        }
    }

    private static int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = (left + right) / 2;
            // 左侧递增，转轴在右侧，最小值在右侧
            if (nums[mid] > nums[right] && mid != left){
                left = mid;
            }
            // 右侧递增，转轴在左侧，最小值在左侧
            else if (nums[mid] < nums[left]){
                right = mid;
            }
            // 重复的数字处转轴，不确定在左侧、右侧
            else if (nums[mid] == nums[right]){
                right--;
            }
            else {
                return Math.min(nums[left],nums[right]);
            }
        }
        return nums[left];
    }
}
