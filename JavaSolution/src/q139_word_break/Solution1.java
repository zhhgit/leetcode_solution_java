package q139_word_break;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args){
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new LinkedList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa"));
        System.out.println(wordBreak(s,wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] breakable = new boolean[len + 1];
        breakable[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                if(breakable[j] && wordDict.contains(s.substring(j,i))){
                    breakable[i] = true;
                }
            }
        }
        return breakable[len];
    }
}
