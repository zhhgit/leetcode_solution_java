package session1.q080_remove_duplicates_from_sorted_array_2;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,3,3,3};
        int len = removeDuplicates(arr);
        System.out.println("length:" + len);
        for(int i=0;i<len;i++){
            System.out.print(arr[i]);
        }
    }

    private static int removeDuplicates(int[] nums) {
        int len = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<len;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
            }
            else if(hm.get(nums[i])==1){
                hm.put(nums[i],2);
            }
        }
        int i=0;
        for(Integer tempKey : hm.keySet()){
            if(hm.get(tempKey)==1){
                nums[i++] = tempKey;
            }
            else if(hm.get(tempKey)==2){
                nums[i++] = tempKey;
                nums[i++] = tempKey;
            }
        }
        Arrays.sort(nums,0,i);
        return i;
    }

}
