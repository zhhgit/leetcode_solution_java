package q003_longest_substring_without_repeating_characters;

import java.util.LinkedList;

/**
 * Created by zhanghao1 on 2017/11/8.
 */
public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"abcabcbb","bbbbb","pwwkew",""};
        for(String s:strs){
            System.out.println(lengthOfLongestSubstring(s));
        }
    }

    private static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(!list.contains(temp)){
                list.add(temp);
                maxLen = Math.max(maxLen,list.size());
            }
            else{
                while(list.size() != 0 && list.peek() != temp){
                    list.removeFirst();
                }
                if(list.size() == 0){
                    list.add(temp);
                }
                else{
                    list.removeFirst();
                    list.add(temp);
                }
                maxLen = Math.max(maxLen,list.size());
            }
        }
        return maxLen;
    }
}
