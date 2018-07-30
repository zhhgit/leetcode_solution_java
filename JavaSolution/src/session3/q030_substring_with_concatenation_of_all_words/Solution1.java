package session3.q030_substring_with_concatenation_of_all_words;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr = {"barfoothefoobarman","wordgoodstudentgoodword","","a"};
        String[][] wordsArr = {{"foo","bar"},{"word","student"},{},{}};
        int len = sArr.length;
        for (int i = 0;i<len;i++){
            System.out.println(findSubstring(sArr[i],wordsArr[i]));
        }
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new LinkedList<>();
        int len = s.length();
        if (words.length == 0 || len == 0){
            return ret;
        }
        int concatLen = getConcatLen(words);
        for (int i = 0;i<=len - concatLen;i++){
            if (isValidPos(words,s.substring(i,i + concatLen))){
                ret.add(i);
            }
        }
        return ret;
    }

    private static int getConcatLen(String[] words){
        int len = 0;
        for (int i = 0;i<words.length;i++){
            len += words[i].length();
        }
        return len;
    }

    // s是否正好是words中字符串的拼接
    private static boolean isValidPos(String[] words,String s){
        int len = words.length;
        boolean[] visited = new boolean[len];
        return backTracking(words,s,0,visited);
    }

    private static boolean backTracking(String[] words,String s,int posInS,boolean[] visited){
        int len = words.length;
        if (allVisited(visited)){
            return true;
        }
        else {
            for (int i = 0;i<len;i++){
                // 没有访问过，且符合
                if (!visited[i] && words[i].equals(s.substring(posInS,posInS + words[i].length()))){
                    visited[i] = true;
                    if (backTracking(words,s,posInS + words[i].length(),visited)){
                        return true;
                    }
                    visited[i] = false;
                }
            }
            return false;
        }
    }

    private static boolean allVisited(boolean[] visited){
        for (int i = 0;i<visited.length;i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
}
