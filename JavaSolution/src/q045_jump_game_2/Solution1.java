package q045_jump_game_2;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    private static int jump(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
