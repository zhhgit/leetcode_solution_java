package session1.q136_single_number;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,3,5,1,5};
        System.out.println(singleNumber(nums));
    }
    private static int singleNumber(int[] nums) {
        int ret = 0;
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
            }
            else{
                hm.remove(nums[i]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                return nums[i];
            }
        }
        return ret;
    }
}
