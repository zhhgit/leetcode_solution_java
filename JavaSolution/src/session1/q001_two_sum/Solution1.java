package session1.q001_two_sum;

import java.util.*;

public class Solution1 {
    public static void main(String[] args)
    {
        int[] input = {2,7,11,15};
        int target = 13;
        int[] output = {0,0};
        output = twoSum(input,target);
        System.out.println(output[0] + "," + output[1]);

    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] outArray = {0,0};
        int temp;
        for(int i = 0; i < nums.length; i++){
            temp = target - nums[i];
            if(map.containsKey(temp)){
                outArray[0] = map.get(temp);
                outArray[1] = i;
            }
            map.put(nums[i],i);
        }
        return outArray;
    }

}
