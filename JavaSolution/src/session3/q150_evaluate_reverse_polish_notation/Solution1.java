package session3.q150_evaluate_reverse_polish_notation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
    public static void main(String[] args){
        String[][] tokensArr = {
                {"2", "1", "+", "3", "*"},
                {"4", "13", "5", "/", "+"},
                {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}
        };
        for (String[] tokens:tokensArr){
            System.out.println(evalRPN(tokens));
        }
    }

    private static int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token:tokens){
            if (!isOperator(token)){
                stack.push(token);
            }
            else{
                int temp;
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                if ("+".equals(token)){
                    temp = num1 + num2;
                }
                else if ("-".equals(token)){
                    temp = num1 - num2;
                }
                else if ("*".equals(token)){
                    temp = num1 * num2;
                }
                else {
                    temp = num1 / num2;
                }
                stack.push(Integer.valueOf(temp).toString());
            }
        }
        return Integer.valueOf(stack.peek());
    }

    private static boolean isOperator(String token){
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }
}
