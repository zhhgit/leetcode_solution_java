package session2.q022_generate_parentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 4;
        for(String str:generateParenthesis(n)){
            System.out.println(str);
        }
    }

    private static List<String>  list = new LinkedList<>();

    private static List<String> generateParenthesis(int n) {
        backTracking("",0,0,n);
        return list;
    }

    private static void backTracking(String str,int left,int right,int n){
        if(str.length() == n * 2){
            list.add(str);
            return;
        }
        if(left < n){
            backTracking(str + "(",left+1,right,n);
        }
        if(right < left){
            backTracking(str + ")",left,right+1,n);
        }
    }
}
