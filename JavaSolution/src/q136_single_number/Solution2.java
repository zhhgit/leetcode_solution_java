package q136_single_number;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by zhanghao1 on 2017/11/7.
 */
public class Solution2 {
    public static void main(String[] args){
        int[] nums = {1,1,2,2,3,3,4};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            if(i+1 < nums.length && nums[i] == nums[i+1]){
                i++;
            }
            else {
                ret = nums[i];
                break;
            }
        }
        return ret;
    }
}
