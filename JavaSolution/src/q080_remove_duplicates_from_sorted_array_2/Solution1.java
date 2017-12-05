package q080_remove_duplicates_from_sorted_array_2;

import common.PrintUtil;

import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        PrintUtil.printNumArray(nums);
    }

    private static int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int i = 0;
        int index = 0;
        while (i < nums.length){
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],1);
                nums[index++] = nums[i];
            }
            else if(hashMap.get(nums[i]) < 2){
                hashMap.put(nums[i],2);
                nums[index++] = nums[i];
            }
            i++;
        }
        return index;
    }
}
