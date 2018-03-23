package session1.q009_palindrome_number;

public class Solution1 {
    public static  void main(String[] args){
        int[] nums = {123,121,1221,-1,100,0};
        for(int i=0; i < nums.length; i++){
            System.out.println(isPalindrome(nums[i]));
        }
    }

    private static boolean isPalindrome(int x) {
        boolean ret = false;
        if(x == 0){
            ret = true;
        }
        else if(x < 0 || x % 10 == 0){
            ret = false;
        }
        else{
            int y = 0;
            while(x > y){
                y = y * 10 + x % 10;
                x = x / 10;
                if(y/10==x || x==y){
                    ret = true;
                }
            }
        }
        return ret;
    }
}
