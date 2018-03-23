package session2.q026_remove_duplicates_from_sorted_array;

/**
 * Created by zhanghao1 on 2017/10/24.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,4,4,5,5,6};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        else{
            int index = 1;
            for(int i = 1;i<nums.length;i++){
                if(nums[i] != nums[i-1]){
                    nums[index] = nums[i];
                    index++;
                }
            }
            return index;
        }
    }
}
