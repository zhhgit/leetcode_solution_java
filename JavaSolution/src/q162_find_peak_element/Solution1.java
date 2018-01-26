package q162_find_peak_element;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{1},{1,2},{2,1},{1,2,3,4},{1,2,3,1},{1, 2, 3,4,5,6,4,2,1},{1,2,7,6,5,4,3,2,1}};
        for(int[] nums:numsArr){
            System.out.println(findPeakElement(nums));
        }
    }

    private static int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return 0;
        }
        int left = 0;
        int right = len -1;
        while (left < right){
            int middle = (left + right) / 2;
            //left和right分别为0,1才会这样
            if(middle == 0){
                if(nums[middle] > nums[right]){
                    return middle;
                }
                else{
                    return right;
                }
            }
            //middle是不可能为len-1的，所以就是一个普通位置
            else{
                //正好满足
                if(nums[middle] > nums[middle-1] && nums[middle] > nums[middle+1]){
                    return middle;
                }
                //单调增取右边
                else if(nums[middle] > nums[middle-1] && nums[middle] < nums[middle+1]){
                    left = middle + 1;
                }
                //单调减取左边
                else if(nums[middle] < nums[middle-1] && nums[middle] > nums[middle+1]){
                    right = middle - 1;
                }
                else{
                    left = middle + 1;
                }
            }
        }
        return left;
    }
}
