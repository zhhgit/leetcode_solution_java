package session1.q055_jump_game;

public class Solution1 {
    public static void main(String[] args){
        int[][] arr = {{2,3,1,1,4},{3,2,1,0,4},{0,2,3}};
        for(int i=0;i<arr.length;i++){
            System.out.println(canJump(arr[i]));
        }
    }

    private static boolean canJump(int[] nums) {
        int maxRange=0;
        int len = nums.length;
        if(len==1){
            return true;
        }
        else{
            int i=0;
            while((i<len-1) && (i<=maxRange)){
                maxRange = Math.max(maxRange,i+nums[i]);
                i++;
            }
            if(maxRange>=len-1){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
