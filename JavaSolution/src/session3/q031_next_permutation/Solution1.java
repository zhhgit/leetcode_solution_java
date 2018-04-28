package session3.q031_next_permutation;

import session3.common.PrintUtil;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{1,2,3},{3,2,1},{1,1,5},{1,3,1,2},{1,2,3,2,1},{1,3,2}};
        for(int i = 0;i<numsArr.length;i++){
            nextPermutation(numsArr[i]);
            PrintUtil.printNumArray(numsArr[i]);
        }
    }

    private static void nextPermutation(int[] nums) {
        int len = nums.length;
        for(int i = len - 1;i >= 0;i--){
            if(i < len - 1){
                //从后往前，递增趋势逆转的位置
                if(nums[i] < nums[i+1]){
                    int j = bigger(nums,i);
                    swap(nums,i,j);
                    Arrays.sort(nums,i+1,len);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    private static void swap(int[] nums,int i,int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //找到i后面比它大的数字中最小数字的位置
    private static int bigger(int[] nums,int i){
        int len = nums.length;
        int min = nums[i+1];
        int minPos = i+1;
        for(int j = i+1;j<len;j++){
            if(nums[j] > nums[i]){
                if(nums[j] < min){
                    minPos = j;
                    min = nums[j];
                }
            }
        }
        return minPos;
    }
}
