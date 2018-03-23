package session2.q167_two_sum_2;

import session2.common.PrintUtil;

public class Solution1 {
    public static void main(String[] args){
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        PrintUtil.printNumArray(twoSum(numbers,target));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                ret[0] = left + 1;
                ret[1] = right + 1;
                return ret;
            }
            else if(numbers[left] + numbers[right] > target){
                right--;
            }
            else{
                left++;
            }
        }
        return ret;
    }
}
