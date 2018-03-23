package session2.q263_ugly_number;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {3,5,6,8,21,12,10};
        for(int num:nums){
            System.out.println(isUgly(num));
        }
    }

    private static boolean isUgly(int num) {
        if(num <= 0){
            return false;
        }
        if(num == 1){
            return true;
        }
        if(num % 2 == 0){
            return isUgly(num / 2);
        }
        if(num % 3 == 0){
            return isUgly(num / 3);
        }
        if(num % 5 == 0){
            return isUgly(num / 5);
        }
        return false;
    }
}
