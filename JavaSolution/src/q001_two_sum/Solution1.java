package q001_two_sum;

import java.util.HashMap;

/**
 * Created by zhanghao1 on 2017/10/23.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {3,2,4};
        int target = 6;
        for(int num: twoSum(nums,target)){
            System.out.println(num);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(hm.containsKey(target - nums[i])){
                ret[0] = hm.get(target - nums[i]);
                ret[1] = i;
                return ret;
            }
            else{
                hm.put(nums[i], i);
            }
        }
        return ret;
    }
}
