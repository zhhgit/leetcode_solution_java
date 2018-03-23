package session1.q075_sort_colors;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,1,0};
        sortColors(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    private static void sortColors(int[] nums) {
        int len = nums.length;
        int[] numArr = {0,0,0};
        for(int i=0;i<len;i++){
            switch(nums[i]){
                case 0:numArr[0]++;break;
                case 1:numArr[1]++;break;
                case 2:numArr[2]++;break;
                default:break;
            }
        }
        int index=0;
        for(int i=0;i<3;i++){
            if(numArr[i]!=0){
                for(int j=0;j<numArr[i];j++){
                    nums[index++] = i;
                }
            }
        }
    }
}
