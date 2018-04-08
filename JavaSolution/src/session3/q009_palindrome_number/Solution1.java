package session3.q009_palindrome_number;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {0,-1,-121,-234,234,121,1221,23532,333,100};
        for(int num:nums){
            System.out.println(num + ":" +isPalindrome(num));
        }
    }

    private static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x == 0){
            return true;
        }
        long xLong = (long) x;
        long xReverse = reverseInt(xLong);
        return xLong == xReverse;
    }

    private static long reverseInt(long x){
        long ret = 0;
        while (x > 0){
            long num = x % 10;
            ret = ret * 10 + num;
            x = x / 10;
        }
        return ret;
    }
}
