package session3.q045_jump_game_2;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    private static int jump(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1){
            return 0;
        }
        int step = 0;
        int currEnd = 0;
        int farthest = 0;
        for (int i =0;i<nums.length - 1;i++){
            farthest = Math.max(farthest,i + nums[i]);
            if (i == currEnd){
                step++;
                currEnd = farthest;
            }
        }
        return step;
    }
}
