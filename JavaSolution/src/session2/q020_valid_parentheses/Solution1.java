package session2.q020_valid_parentheses;

import java.util.Stack;

/**
 * Created by zhanghao1 on 2017/10/24.
 */
public class Solution1 {
    public static void main(String[] args){
        String[] arr = {"()","()[]{}","(]","([)]"};
        for(String str: arr){
            System.out.println(isValid(str));
        }
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char currChar = s.charAt(i);
            if(!stack.isEmpty()){
                char currPeak = stack.peek();
                if((currChar == ')' && currPeak == '(') || (currChar == '}' && currPeak == '{') || (currChar == ']' && currPeak == '[') ){
                    stack.pop();
                }
                else{
                    stack.push(currChar);
                }
            }
            else{
                stack.push(currChar);
            }

        }
        return stack.isEmpty();
    }
}
