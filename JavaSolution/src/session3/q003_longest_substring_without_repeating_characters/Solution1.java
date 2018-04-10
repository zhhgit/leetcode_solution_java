package session3.q003_longest_substring_without_repeating_characters;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"abcabcbb","bbbbb","pwwkew"};
        for(String s:strs){
            System.out.println(lengthOfLongestSubstring(s));
        }
    }

    private static int lengthOfLongestSubstring(String s) {
        Queue<Character> list = new LinkedList<>();
        int maxLen = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(!list.contains(c)){
                list.offer(c);
            }
            else{
                while (list.size() > 0 && list.peek() != c){
                    list.poll();
                }
                list.poll();
                list.offer(c);
            }
            if(list.size() > maxLen){
                maxLen = list.size();
            }
        }
        return maxLen;
    }
}
