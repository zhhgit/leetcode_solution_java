package session3.q032_longest_valid_parentheses;

public class Solution1 {

    public static void main(String[] args){
        String[] arr = {"(()",")()())"};
        for (String s:arr){
            System.out.println(longestValidParentheses(s));
        }
    }

    private static int longestValidParentheses(String s) {
        int len = s.length();
        int ret = 0;
        for (int i = 0;i<len - 1;i++){
            ret = Math.max(ret,longestAtPos(s,i));
        }
        return ret;
    }

    private static int longestAtPos(String s,int pos){
        int left = 0;
        int right = 0;
        int len = s.length();
        int ret = 0;
        while (pos < len && left >= right){
            if (s.charAt(pos) == '('){
                left++;
            }
            else{
                right++;
            }
            pos++;
            if (left == right){
                ret = left * 2;
            }
        }
        return ret;
    }
}
