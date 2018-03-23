package session1.q020_valid_parentheses;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr = {")"};
        int len = sArr.length;
        for(int i=0; i<len; i++ ){
            System.out.println(isValid(sArr[i]));
        }
    }

    private static boolean isValid(String s){
        Stack<Character> cStack = new Stack<Character>();
        boolean ret = false;
        char temp;
        char[] sArr = s.toCharArray();
        int len = sArr.length;
        for(int i = 0; i<len;i++){
            if(sArr[i] == '('){
                cStack.push(sArr[i]);
            }
            else if(sArr[i] == '['){
                cStack.push(sArr[i]);
            }
            else if(sArr[i] == '{'){
                cStack.push(sArr[i]);
            }
            else if(sArr[i] == ')'){
                if((!cStack.isEmpty()) && cStack.peek().equals('(')){
                    cStack.pop();
                }
                else{
                    return false;
                }
            }
            else if(sArr[i] == ']'){
                if((!cStack.isEmpty()) && cStack.peek().equals('[')){
                    cStack.pop();
                }
                else{
                    return false;
                }
            }
            else if(sArr[i] == '}'){
                if((!cStack.isEmpty()) && cStack.peek().equals('{')){
                    cStack.pop();
                }
                else{
                    return false;
                }
            }
            else{
            }
        }
        if(cStack.isEmpty()){
            ret = true;
        }
        return ret;
    }
}
