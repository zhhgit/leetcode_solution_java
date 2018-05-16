package session3.q075_sort_colors;

import session3.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {2,0,2,1,0,1,0,0,0,2,1,0,1};
        sortColors(nums);
        PrintUtil.printNumArray(nums);
    }

    private static void sortColors(int[] nums) {
        int len = nums.length;
        //可供交换为0的最前面的位置，该位置之前的都已经置为0
        int zeroPos = 0;
        //可供交换为2的最后面的位置，该位置之后的都已经置为2
        int twoPos = len - 1;
        for(int i = 0;i<=twoPos;i++){
            while (nums[i] == 2 && i < twoPos){
                swap(nums,i,twoPos);
                twoPos--;
            }
            while (nums[i] == 0 && i > zeroPos){
                swap(nums,i,zeroPos);
                zeroPos++;
            }
        }
    }

    private static void swap(int[] nums,int i,int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
