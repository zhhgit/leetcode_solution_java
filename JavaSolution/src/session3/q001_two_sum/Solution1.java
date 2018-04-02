package session3.q001_two_sum;

import java.util.HashMap;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
    	int[] nums = {2, 7, 11, 15};
    	int target = 9;
    	PrintUtil.printNumArray(twoSum(nums,target));
    }

    private static int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> hashMap = new HashMap<>();
    	int[] retArr = new int[2];
    	for(int i = 0;i<nums.length;i++) {
    		int remain = target - nums[i];
    		if(!hashMap.containsKey(remain)) {
    			hashMap.put(nums[i], i);
    		}
    		else {
    			retArr[0] = hashMap.get(remain); 
    			retArr[1] = i;
    			return retArr;
    		}
    	}
        return retArr;
    }
}
