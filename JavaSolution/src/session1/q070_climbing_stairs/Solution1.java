package session1.q070_climbing_stairs;

public class Solution1 {
    public static void main(String[] args){
        int n = 4;
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        int ret = 0;
        int prev1 = 2;
        int prev2 = 1;
        if(n <= 0){
            ret = 0;
        }
        else if(n == 1){
            ret = 1;
        }
        else if(n == 2){
            ret = 2;
        }
        else {
            for(int i = 2; i < n; i++){
                ret = prev1 + prev2;
                prev2 = prev1;
                prev1 = ret;
            }
        }
        return ret;
    }
}
