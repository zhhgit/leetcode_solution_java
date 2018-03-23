package session1.q022_generate_parentheses;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int n = 4;
        System.out.println(generateParenthesis(n));
    }

    private static ArrayList<String> ret = new ArrayList<>();

    private static List<String> generateParenthesis(int n) {
        backTracking("",0,0,n);
        return ret;
    }

    private static void backTracking(String str,int left,int right,int n){
        if(str.length() == 2*n){
            ret.add(str);
        }
        if(left<n){
            backTracking(str+'(',left+1,right,n);
        }
        if(right<left){
            backTracking(str+')',left,right+1,n);
        }
    }
}
