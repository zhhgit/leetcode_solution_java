package q125_valid_palindrome;

/**
 * Created by zhanghao1 on 2017/11/7.
 */
public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"A man, a plan, a canal: Panama","race a car",".,","abba","abca"};
        for(String s:strs){
            System.out.println(isPalindrome(s));
        }
    }

    private static boolean isPalindrome(String s) {
        s = parseString(s);
        int left = 0,right = s.length() -1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean charInRange(char c){
        boolean flag1 = c <= 'z' && c >= 'a';
        boolean flag2 = c <= '9' && c >= '0';
        if(flag1 || flag2){
            return true;
        }
        else {
            return false;
        }
    }

    private static String parseString(String s){
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(charInRange(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
