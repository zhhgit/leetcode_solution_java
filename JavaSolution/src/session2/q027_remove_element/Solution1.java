package session2.q027_remove_element;

/**
 * Created by zhanghao1 on 2017/10/25.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {3,2,1,3,2};
        int val = 3;
        System.out.println("count:" + removeElement(nums,val));
        for(int num: nums){
            System.out.println(num);
        }
    }

    private static int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i<nums.length;i++){
            if(val != nums[i]){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
