package session2.q009_palindrome_number;

/**
 * Created by zhanghao1 on 2017/10/24.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {5,12,323,44,0,345543,-1};
        for(int num: nums){
            System.out.println(isPalindrome(num));
        }
    }

    private static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        else if(x == 0){
            return true;
        }
        else{
            return reverseInt((long) x);
        }
    }

    private static boolean reverseInt(long x){
        long original = x;
        long temp = 0;
        while(x > 0){
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        if(temp == original){
            return true;
        }
        else {
            return false;
        }
    }
}
