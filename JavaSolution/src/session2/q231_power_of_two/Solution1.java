package session2.q231_power_of_two;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {0,1,2,3,4,5,6,7,8};
        for(int num:nums){
            System.out.println(isPowerOfTwo(num));
        }
    }

    private static boolean isPowerOfTwo(int n) {
        if(n < 1){
            return false;
        }
        if(n == 1){
            return true;
        }
        while(n >= 2){
           if(n % 2 == 1){
               return false;
           }
           n = n / 2;
        }
        return true;
    }
}
