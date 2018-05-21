package session3.q070_climbing_stairs;

public class Solution1 {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        for(int n:arr){
            System.out.println(climbStairs(n));
        }
    }

    private static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] store = new int[n];
        store[0] = 1;
        store[1] = 2;
        for(int i = 2;i<n;i++){
            store[i] = store[i-1] + store[i-2];
        }
        return store[n-1];
    }
}
