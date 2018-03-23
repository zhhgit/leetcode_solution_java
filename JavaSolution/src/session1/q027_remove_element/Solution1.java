package session1.q027_remove_element;

public class Solution1 {
    public static  void main(String[] args){
        int[] inputArr = {3,2,2,3};
        System.out.println(removeElement(inputArr,3));
    }

    private static int removeElement(int[] nums, int val){
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[ret++] = nums[i];
            }
        }
        return ret;
    }
}
