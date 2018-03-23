package session2.q067_add_binary;

import java.util.Stack;

/**
 * Created by zhanghao1 on 2017/11/1.
 */
public class Solution1 {
    public static void main(String[] args){
        String str1 = "10";
        String str2 = "100";
        System.out.println(addBinary(str1,str2));
    }

    private static String addBinary(String a, String b) {
        String newA,newB;
        //先进行字符串的补零操作
        int lenGap = Math.abs(a.length() - b.length());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<lenGap;i++){
            sb.append("0");
        }
        String addStr = sb.toString();
        if(a.length() < b.length()){
            newA = addStr + a;
            newB = b;
        }
        else if(a.length() == b.length()){
            newA = a;
            newB = b;
        }
        else{
            newA = a;
            newB = addStr + b;
        }
        return addBinarySameLen(newA,newB);
    }

    //对等长字符串进行操作
    private static String addBinarySameLen(String a, String b){
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int backIndex = a.length()-1;
        int tempSum,carry = 0;
        for(int i=backIndex;i>=0;i--){
            tempSum = (a.charAt(i) - '0') +  (b.charAt(i) - '0') + carry;
            stack.push(String.valueOf(tempSum % 2).charAt(0));
            carry = tempSum / 2;
        }
        if(carry > 0){
            stack.push('1');
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
