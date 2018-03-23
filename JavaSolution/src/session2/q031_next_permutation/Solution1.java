package session2.q031_next_permutation;

import common.PrintUtil;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{1,2,3},{3,2,1},{1,1,5}};
        for(int[] nums:numsArr){
            nextPermutation(nums);
            PrintUtil.printNumArray(nums);
        }
    }

    private static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i=len - 1;
        //找到从末尾开始第一个比后面小的值
        while(i >=0 && i-1 >=0 && nums[i-1] >= nums[i]){
            i--;
        }
        //倒序的，直接从小到大排序
        if(i == 0){
            Arrays.sort(nums);
            return;
        }
        int changePos1 = i-1;
        //找到changePos后面，第一个比它大的值
        i=len-1;
        while(i>=0 && nums[i]<= nums[changePos1]){
            i--;
        }
        int changePos2 = i;
        //交换两个changePos
        swap(nums,changePos1,changePos2);
        //升序排列changePos后面的所有数字
        Arrays.sort(nums,changePos1 + 1,len);
    }

    private static void swap(int[] nums,int i,int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
