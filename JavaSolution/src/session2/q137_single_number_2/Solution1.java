package session2.q137_single_number_2;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {2,2,2,3,3,3,4};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int ret = nums[0];
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                count++;
            }
            else{
                //后一个与前一个不等
                if(nums[i] != nums[i-1]){
                    //且此时计数为1，一定是前面的数字
                    if(count == 1){
                        ret = nums[i-1];
                    }
                    count = 1;
                }
                //后一个与前一个相等
                else{
                    count++;
                }
            }
        }
        if(count == 1){
            ret = nums[nums.length-1];
        }
        return ret;
    }
}
