package q032_longest_valid_parentheses;

import java.util.Stack;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {")()(()))()()()()"};
        for(String s:strs){
            System.out.println(longestValidParentheses(s));
        }
    }

    private static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            //stack中存放的是'('的位置
            if(s.charAt(j)=='('){
                stack.push(j);
            }
            //为')'
            else {
                //连续出现的断开了的情况，')'出现的个数比'('多
                if (stack.isEmpty()){
                    left=j;
                }
                else{
                    stack.pop();
                    //出现过的'(',')'个数相等
                    if(stack.isEmpty()){
                        max=Math.max(max,j-left);
                    }
                    //不等，有多余的'('在stack中
                    else{
                        max=Math.max(max,j-stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
