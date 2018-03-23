package session2.q033_search_in_rotated_sorted_array;

public class Solution1 {

    public static void main(String[] args){
        int[] nums = {3,1};
        int[] targets = {0,1,3};
        for(int num:targets){
            System.out.println(search(nums,num));
        }
    }

    private static int search(int[] nums, int target) {
        if(nums.length ==0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int middle = (left + right) / 2;
            if(nums[middle] == target){
                return middle;
            }
            //转轴在右侧
            else if(nums[middle] >= nums[left]){
                if(targetInRange(nums,left,middle,target)){
                    right = middle -1;
                }
                else{
                    left = middle + 1;
                }
            }
            //转轴在左侧
            else{
                if(targetInRange(nums,middle,right,target)){
                    left = middle + 1;
                }
                else{
                    right = middle -1;
                }
            }
        }
        if(nums[left] == target){
            return left;
        }
        else{
            return -1;
        }
    }

    private static boolean targetInRange(int[] nums,int left,int right,int target){
        return target <= nums[right] && target >= nums[left];
    }
}