package session1.q005_longest_palindromic_substring;

public class Solution1 {
    public static void main(String[] args){
        String[] arr = {"bb"};
        for(int i=0; i<arr.length; i++){
            System.out.println(longestPalindrome(arr[i]));
        }
    }

    private static int max = 0;
    private static int leftPos = 0;

    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len<2){
            return s;
        }
        else{
            for(int i=0; i<s.length(); i++){
                extendString(s,i,i);
                extendString(s,i,i+1);
            }
            return s.substring(leftPos,leftPos+max);
        }
    }

    private static void extendString(String s, int left, int right){
        while((left>=0)&&(right<s.length())&&(s.charAt(left)==s.charAt(right))){
            left--;
            right++;
        }
        if(right-left-1 > max){
            max = right-left-1;
            leftPos = left+1;
        }
    }
}
