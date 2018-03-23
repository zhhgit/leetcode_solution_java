package session2.q081_search_in_rotated_sorted_array_2;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,5,1,1,1,1};
        int[] targets = {0,1,2,3,4,5,6};
        for(int target:targets){
            System.out.println(search(nums,target));
        }
    }

    private static boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        int left = 0,right = nums.length-1;
        while (left < right){
            int middle = (left + right) / 2;
            if(nums[middle] == target){
                return true;
            }
            //左侧递增
            else if(nums[middle] > nums[left]){
                //在递增范围内
                if(targetInRange(nums,left,middle,target)){
                    right = middle - 1;
                }
                else{
                    left = middle + 1;
                }
            }
            //右侧递增
            else if(nums[middle] < nums[left]){
                if(targetInRange(nums,middle,right,target)){
                    left = middle + 1;
                }
                else{
                    right = middle - 1;
                }
            }
            //middle与left的值相等，因为比较的是左边的所以左侧++
            else{
                left++;
            }
        }
        return nums[left] == target;
    }

    private static boolean targetInRange(int[] nums,int left,int right,int target){
        return target <= nums[right] && target >= nums[left];
    }
}
