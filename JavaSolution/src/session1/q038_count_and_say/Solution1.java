package session1.q038_count_and_say;

import java.util.*;

public class Solution1 {
    public static  void main(String[] args){
        int n = 4;
        System.out.println(countAndSay(n));

    }

    private static String countAndSay(int n){
        String sequence = "1";
        for(int i=0; i<n-1; i++){
            sequence = generator(sequence);
        }
        return sequence;
    }

    private static String generator(String n){
        Stack<Character> s = new Stack<Character>();
        StringBuffer sb = new StringBuffer();
        int size,i;
        char[] cArr = n.toCharArray();
        int len = cArr.length;
        for(i=0;i<len;i++) {
            if (s.isEmpty()) {
                s.push(cArr[i]);
            } else if (s.peek() == cArr[i]) {
                s.push(cArr[i]);
            } else {
                size = s.size();
                sb.append(Integer.toString(size));
                sb.append(s.peek().toString());
                s.clear();
                s.push(cArr[i]);
            }
        }
        if(i == len){
            if(!s.isEmpty()){
                size = s.size();
                sb.append(Integer.toString(size));
                sb.append(s.peek().toString());
            }
        }
        return sb.toString();
    }
}