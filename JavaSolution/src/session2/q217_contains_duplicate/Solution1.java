package session2.q217_contains_duplicate;

import java.util.HashSet;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num: nums){
            if(hashSet.contains(num)){
                return true;
            }
            else{
                hashSet.add(num);
            }
        }
        return false;
    }
}
