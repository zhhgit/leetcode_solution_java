package session2.q169_majority_element;

import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,1,1,2};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int len = nums.length;
        int half = len / 2;
        for(int i=0;i<nums.length;i++){
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],1);
            }
            else{
                hashMap.put(nums[i],hashMap.get(nums[i]) + 1);
            }
            if(hashMap.get(nums[i]) > half){
                return nums[i];
            }
        }
        return getMaxKey(hashMap);
    }

    private static int getMaxKey(HashMap<Integer,Integer> hashMap){
        int maxKey = 0;
        int maxValue = Integer.MIN_VALUE;
        for(Integer key:hashMap.keySet()){
            if(hashMap.get(key) > maxValue){
                maxValue = hashMap.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }
}
