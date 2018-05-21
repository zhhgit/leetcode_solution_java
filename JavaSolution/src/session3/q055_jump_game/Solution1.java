package session3.q055_jump_game;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{3,2,1,0,4},{2,3,1,1,4}};
        for(int[] nums:numsArr){
            System.out.println(canJump(nums));
        }
    }

    private static boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        int i = 0;
        while (i<len && i<=max){
            max = Math.max(max,nums[i] + i);
            i++;
        }
        return max >= len - 1;
    }
}
