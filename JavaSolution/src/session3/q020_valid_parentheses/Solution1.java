package session3.q020_valid_parentheses;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"}]","()"};
        for(String s:strs){
            System.out.println(isValid(s));
        }
    }

    private static boolean isValid(String s) {
        int len = s.length();
        if(len == 0){
            return true;
        }
        if(len % 2 == 1){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0;i<len;i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                //注意这里要保证stack中有元素，否则stack.peek()为null，再与'(','[','{'在用==比较时，会抛异常！！
                if(stack.size() > 0){
                    if((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{')){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
