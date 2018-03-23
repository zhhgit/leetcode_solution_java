package session2.q075_sort_colors;

import common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {2,1,1,2,0,0,1,0,1,2};
        PrintUtil.printNumArray(nums);
        System.out.println("----------------");
        sortColors(nums);
        PrintUtil.printNumArray(nums);
    }

    private static void sortColors(int[] nums) {
        if(nums.length <=1){
            return;
        }
        int[] count = new int[3];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int pos = 0;
        for(int i = 0;i<count.length;i++){
            int temp = count[i];
            while (temp > 0){
                nums[pos] = i;
                pos++;
                temp--;
            }
        }
    }
}
