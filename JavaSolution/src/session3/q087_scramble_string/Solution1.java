package session3.q087_scramble_string;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        String[] s1Arr = {"great","abcde","abab"};
        String[] s2Arr = {"rgeat","caebd","aabb"};
        for(int i = 0;i<s1Arr.length;i++){
            System.out.println(isScramble(s1Arr[i],s2Arr[i]));
        }
    }

    private static boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2){
            return false;
        }
        if (len1 <= 3){
            char[] s1CharArray = s1.toCharArray();
            Arrays.sort(s1CharArray);
            String s1Sort = new String(s1CharArray);
            char[] s2CharArray = s2.toCharArray();
            Arrays.sort(s2CharArray);
            String s2Sort = new String(s2CharArray);
            if (!s1Sort.equals(s2Sort)){
                return false;
            }
            else{
                return true;
            }
        }
        for (int i = 2;i<len1 - 1;i++){
            String leftStr1 = s1.substring(0,i);
            String rightStr1 = s1.substring(i,len1);
            String leftStr2 = s2.substring(0,i);
            String rightStr2 = s2.substring(i,len2);
            if (isScramble(leftStr1,leftStr2) && isScramble(rightStr1,rightStr2)){
                return true;
            }
        }
        return false;
    }
}
