package session3.q005_longest_palindromic_substring;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"abbc","babad","daffa"};
        for(String s:strs){
            System.out.println(longestPalindrome(s));
        }
    }

    private static int maxLen;
    private static String retStr;

    private static String longestPalindrome(String s) {
        maxLen = 1;
        retStr = "";
        int len = s.length();
        if(len == 0){
            return "";
        }
        if (len == 1){
            return s;
        }
        retStr = s.substring(0,1);
        for(int i=0;i< len;i++){
            extendAtPos(s,i,i);
            if(i+1 < len){
                extendAtPos(s,i,i+1);
            }
        }
        return retStr;
    }

    private static void extendAtPos(String s,int left, int right){
        while (inRange(s,left) && inRange(s,right) && (s.charAt(left) == s.charAt(right))){
            left--;
            right++;
        }
        int len = right - left - 1;
        if(len > maxLen){
            maxLen = len;
            retStr = s.substring(left+1,right);
        }
    }

    private static boolean inRange(String s,int pos){
        int len = s.length();
        return (pos>=0) && (pos<len);
    }
}
