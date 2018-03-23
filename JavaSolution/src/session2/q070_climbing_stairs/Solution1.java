package session2.q070_climbing_stairs;

/**
 * Created by zhanghao1 on 2017/11/1.
 */
public class Solution1 {
    public static void main(String[] args){
        int n = 6;
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        if(n<=0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        int[] resultArr = new int[n + 1];
        resultArr[0] = 0;
        resultArr[1] = 1;
        resultArr[2] = 2;
        return recursiveClimb(n,resultArr);
    }

    private static int recursiveClimb(int n,int[] resultArr){
        if(resultArr[n] != 0){
            return resultArr[n];
        }
        else{
            int result = recursiveClimb(n-2,resultArr) + recursiveClimb(n-1,resultArr);
            resultArr[n] = result;
            return result;
        }
    }
}
