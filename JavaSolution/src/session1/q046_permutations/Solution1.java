package session1.q046_permutations;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        ret.add(new LinkedList<>());
        for(int i=0;i<nums.length;i++){
            while(ret.peek().size()==i){
                List<Integer> temp = ret.remove();
                for(int j=0;j<nums.length;j++) {
                    if (!temp.contains(nums[j])) {
                        LinkedList<Integer> insert = new LinkedList<>(temp);
                        insert.add(nums[j]);
                        ret.add(insert);
                    }
                }
            }
        }
        return ret;
    }
}
