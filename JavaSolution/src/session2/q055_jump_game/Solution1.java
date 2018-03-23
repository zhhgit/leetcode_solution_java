package session2.q055_jump_game;

public class Solution1 {
    public static void main(String[] args){
        int[][] numsArr = {{2,3,1,1,4},{3,2,1,0,4}};
        for(int[] nums:numsArr){
            System.out.println(canJump(nums));
        }
    }

    private static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return false;
        }
        int pos = 0;
        int max = 0;
        while (pos < nums.length && pos <= max){
            max = Math.max(max,pos + nums[pos++]);
        }
        return max >= nums.length-1;
    }
}
