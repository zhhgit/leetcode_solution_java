package session3.q015_3sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        int len = nums.length;
        if(len <= 2){
            return lists;
        }
        Arrays.sort(nums);
        for(int i = 0;i<len-2;i++){
            while (i-1 >=0 && i<len-2 && nums[i-1] == nums[i]){
                i++;
            }
            twoSumWithRemain(lists,nums,i + 1,0-nums[i]);
        }
        return lists;
    }

    private static void twoSumWithRemain(List<List<Integer>> lists,int[] nums,int pos,int remain){
        if(remain < 0){
            return;
        }
        int len = nums.length;
        int left = pos;
        int right = len -1;
        while (left < right){
            if(remain == nums[left] + nums[right]){
                List<Integer> addList = new LinkedList<>(Arrays.asList(0-remain,nums[left],nums[right]));
                lists.add(addList);
                left++;
                right--;
                while (left < right && nums[left] == nums[left-1]){
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]){
                    right--;
                }
            }
            else if(remain > nums[left] + nums[right]){
                left++;
                while (left < right && nums[left] == nums[left-1]){
                    left++;
                }
            }
            else {
                right--;
                while (left < right && nums[right] == nums[right + 1]){
                    right--;
                }
            }
        }
    }
}
