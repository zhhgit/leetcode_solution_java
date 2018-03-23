package session2.q035_search_insert_position;

/**
 * Created by zhanghao1 on 2017/10/26.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int[] targetArr = {5,2,7,0};
        for(int target:targetArr){
            System.out.println(searchInsert(nums,target));
        }
    }

    private static int searchInsert(int[] nums, int target) {
        int index = 0;
        while(index< nums.length && nums[index] < target){
            index++;
        }
        return index;
    }
}
