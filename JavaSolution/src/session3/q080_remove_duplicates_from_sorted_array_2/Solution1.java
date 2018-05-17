package session3.q080_remove_duplicates_from_sorted_array_2;

import session3.common.PrintUtil;

import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {0,1,1,1,2,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println("---------------------");
        PrintUtil.printNumArray(nums);
    }

    private static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(!hashMap.containsKey(nums[i])){
                nums[index++] = nums[i];
                hashMap.put(nums[i],1);
            }
            else{
                int count = hashMap.get(nums[i]);
                if(count == 1){
                    nums[index++] = nums[i];
                    hashMap.put(nums[i],2);
                }
            }
        }
        return index;
    }
}
