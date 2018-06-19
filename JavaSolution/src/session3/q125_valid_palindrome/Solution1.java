package session3.q125_valid_palindrome;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"A man, a plan, a canal: Panama","","a","race a car","bc","aa"};
        for (String s:strs){
            System.out.println(isPalindrome(s));
        }
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0){
            return true;
        }
        int left = 0;
        int right = len - 1;
        while (left < right){
            while (left <right && !isAlphaNumeric(s.charAt(left))){
                left++;
            }
            while (left <right && !isAlphaNumeric(s.charAt(right))){
                right--;
            }
            if (!charEquals(s.charAt(left),s.charAt(right))){
                return false;
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static boolean isAlphaNumeric(char c){
        return (c>= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private static boolean isAlphaOrNum(char c){
        if ((c>= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean charEquals(char c1,char c2){
        if (!isAlphaOrNum(c1) && !isAlphaOrNum(c2)){
            return (c1 == c2);
        }
        else if (isAlphaOrNum(c1) && isAlphaOrNum(c2)){
            int c1Val,c2Val;
            if (c1 >= 'A' && c1 <= 'Z'){
                c1Val = c1 - 'A';
            }
            else {
                c1Val = c1 - 'a';
            }
            if (c2 >= 'A' && c2 <= 'Z'){
                c2Val = c2 - 'A';
            }
            else {
                c2Val = c2 - 'a';
            }
            return c1Val == c2Val;
        }
        else {
            return false;
        }
    }
}
