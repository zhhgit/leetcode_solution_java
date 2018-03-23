package session1.q003_longest_substring_without_repeating_characters;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        String[] arr = {"abcabcbb","bbbbb","pwwkew","abcada"};
        for(int i=0; i<arr.length; i++){
            System.out.println(lengthOfLongestSubstring(arr[i]));
        }
    }

    private static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
        if(len == 0){
            return 0;
        }
        else{
            for(int i=0,j=0; i<len; i++){
                if(hm.containsKey(s.charAt(i))){
                    j = Math.max(j,hm.get(s.charAt(i))+1);
                }
                hm.put(s.charAt(i),i);
                max = Math.max(max,i-j+1);
            }
            return max;
        }
    }
}
