package session3.q035_search_insert_position;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int[] targets = {0,2,5,7};
        for(int i = 0;i<targets.length;i++){
            System.out.println(searchInsert(nums,targets[i]));
        }
    }

    private static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == target){
                return i;
            }
            else if(nums[i] > target){
                return i;
            }
        }
        return len;
    }
}
