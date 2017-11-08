package q005_longest_palindromic_substring;

/**
 * Created by zhanghao1 on 2017/11/8.
 */
public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"babad","","cbbd","aaa"};
        for(String s:strs){
            //当有static变量时，每次调用方法前要对变量重置，否则出错。
            maxLen = 0;
            leftPos = 0;
            System.out.println(longestPalindrome(s));
        }
    }

    private static int leftPos = 0;
    private static int maxLen = 0;

    private static String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        for(int i=0;i<s.length();i++){
            extendString(s,i,i);
            extendString(s,i,i+1);
        }
        return s.substring(leftPos,leftPos+maxLen);
    }

    private static void extendString(String s,int left,int right){
        while(indexInRange(s,left) && indexInRange(s,right) && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(right-left-1 > maxLen){
            maxLen = right - left -1;
            leftPos = left + 1;
        }
    }

    private static boolean indexInRange(String s, int index){
        return (index >=0) && (index < s.length());
    }
}
