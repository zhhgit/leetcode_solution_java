package session2.q041_first_missing_positive;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {3,4,-1,1,1};
        System.out.println(firstMissingPositive(nums));
    }

    private static int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int i=0;
        //跳过小于等于0的
        while(i< len &&  nums[i] <= 0){
            i++;
        }
        //如果已经到最后
        if(i == len){
            return 1;
        }
        //没到最后且当前的为1，这才是正常的
        else if(nums[i] == 1){
            i++;
            while(i< len){
                //判断此后的每一个是否满足比前一个大1或者相等
                if(nums[i] - nums[i-1] != 0 && nums[i] - nums[i-1] != 1){
                    return nums[i-1] + 1;
                }
                else{
                    i++;
                }
            }
            //已经到最后
            return nums[len-1] + 1;
        }
        //没到最后但是非1，缺少1
        else{
            return 1;
        }
    }
}
