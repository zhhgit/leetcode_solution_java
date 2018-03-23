package session1.q034_search_for_a_range;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1,5,5,7,8};
        int target = 5;
        int[] result = searchRange(arr,target);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    private static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0,right = len-1;
        int[] ret = {-1,-1};
        if((len==0) || (target<nums[0]) || (target> nums[right])){
            return ret;
        }
        else if(len==1){
            if(target==nums[0]){
                ret[0] = 0;
                ret[1] = 0;
            }
            return ret;
        }
        else{
            while(left<right){
                int middle = (left+right)/2;
                if(nums[middle]<target){
                    left=middle+1;
                }
                else{
                    right=middle;
                }
            }
            if(nums[left]!=target){
                return ret;
            }
            else{
                ret[0] = left;
            }
            left=0;
            right=len-1;
            while(left<right){
                int middle = (left+right+1)/2;
                if(nums[middle]>target){
                    right=middle-1;
                }
                else{
                    left=middle;
                }
            }
            ret[1] = right;
            return ret;
        }
    }
}
