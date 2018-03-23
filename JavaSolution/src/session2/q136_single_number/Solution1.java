package session2.q136_single_number;

import java.util.HashSet;

/**
 * Created by zhanghao1 on 2017/11/7.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,1,2,2,3,3,4};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!hashSet.contains(nums[i])){
                hashSet.add(nums[i]);
            }
            else{
                hashSet.remove(nums[i]);
            }
        }
        Integer ret = 0;
        for(Integer num:hashSet){
            ret = num;
        }
        return ret;
    }
}
