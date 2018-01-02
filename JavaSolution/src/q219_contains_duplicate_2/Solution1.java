package q219_contains_duplicate_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums,k));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!hashMap.containsKey(nums[i])){
                List<Integer> addList = new LinkedList<>();
                addList.add(i);
                hashMap.put(nums[i],addList);
            }
            else{
                List<Integer> oldList = hashMap.get(nums[i]);
                for(int index:oldList){
                    if(Math.abs(index - i) <= k){
                        return true;
                    }
                }
                oldList.add(i);
            }
        }
        return false;
    }
}
