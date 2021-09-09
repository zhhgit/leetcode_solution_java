package algorithm1.dynamicProgramming;

public class ClimbStairs {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] resultArr = new int[n];
        resultArr[0] = 1;
        resultArr[1] = 2;
        for (int i = 2; i < n; i++){
            resultArr[i] = resultArr[i - 1] + resultArr[i - 2];
        }
        return resultArr[n - 1];
    }
}
