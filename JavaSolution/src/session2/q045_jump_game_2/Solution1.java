package session2.q045_jump_game_2;

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
            // 当前位置达到了当前步数能到达的最远位置，必须再跳一步，并将当前步数最远距离更新为当前位置最远距离。
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
