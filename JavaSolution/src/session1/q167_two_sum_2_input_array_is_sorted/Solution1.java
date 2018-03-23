package session1.q167_two_sum_2_input_array_is_sorted;

public class Solution1 {
    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] ret = twoSum(numbers,target);
        for(int i=0;i<ret.length;i++){
            System.out.println(ret[i]);
        }
    }
    private static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] ret = {0,0};
        int left = 0,right = len-1;
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                ret[0] = left+1;
                ret[1] = right+1;
                break;
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return ret;
    }
}
