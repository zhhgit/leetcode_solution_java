package session1.q026_remove_duplicates_from_sorted_array;

public class Solution1 {
    public static  void main(String[] args){
        int[] inputArr = {1,2,3};
        System.out.println(removeDuplicates(inputArr));
    }

    private static int removeDuplicates(int[] nums){
        int retIndex;
        int len = nums.length;
        if(len == 0){
            retIndex = 0;
        }
        else if(len == 1){
            retIndex = 1;
        }
        else{
            retIndex = 1;
            for(int i=0; i< nums.length-1;i++){
                if(nums[i]!=nums[i+1]){
                    nums[retIndex++] = nums[i+1];
                }
            }
        }
        return retIndex;
    }
}
