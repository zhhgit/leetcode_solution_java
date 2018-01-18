package q150_evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution1 {
    public static void main(String[] args){
        String[][] tokensArr = {{"2", "1", "+", "3", "*"},{"4", "13", "5", "/", "+"}};
        for(String[] tokens:tokensArr){
            System.out.println(evalRPN(tokens));
        }
    }

    private static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int ele2 = Integer.valueOf(stack.pop());
                int ele1 = Integer.valueOf(stack.pop());
                stack.push(doCal(ele1,ele2,tokens[i]));
            }
            else{
                stack.push(tokens[i]);
            }
        }
        return Integer.valueOf(stack.peek());
    }

    private static String doCal(int ele1,int ele2,String operator){
        int result;
        if(operator.equals("+")){
            result = ele1+ele2;
        }
        else if(operator.equals("-")){
            result = ele1-ele2;
        }
        else if(operator.equals("*")){
            result = ele1*ele2;
        }
        else {
            result = ele1/ele2;
        }
        return result + "";
    }
}
