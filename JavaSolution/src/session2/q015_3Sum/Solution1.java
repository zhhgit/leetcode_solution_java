package session2.q015_3Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        if(nums.length < 3){
            return lists;
        }
        for(int i=0;i<nums.length - 2;i++){
            while(inRange(nums,i) && inRange(nums,i-1) && nums[i] == nums[i-1]){
                i++;
            }
            eachRound(nums,lists,i,0-nums[i]);
        }
        return lists;
    }

    private static boolean inRange(int[] nums,int pos){
        return (pos >=0) && (pos <nums.length -2);
    }

    private static void eachRound(int[] nums,List<List<Integer>> lists,int pos,int remain){
        if(remain < 0){
            return;
        }
        int left = pos + 1;
        int right = nums.length -1;
        while(left < right){
            if(nums[left] + nums[right] == 0 - nums[pos]){
                List<Integer> addList = new LinkedList<>();
                addList.add(nums[pos]);
                addList.add(nums[left]);
                addList.add(nums[right]);
                lists.add(addList);
                //特别要小心这里的重复的判断，否则会死循环
                left++;
                right--;
                while (left < nums.length && nums[left] == nums[left-1]){
                    left++;
                }
                while(right >=0 && nums[right] == nums[right+1]){
                    right--;
                }
            }
            else if(nums[left] + nums[right] < remain){
                left++;
            }
            else{
                right--;
            }
        }
    }
}
