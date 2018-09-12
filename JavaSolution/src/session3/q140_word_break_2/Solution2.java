package session3.q140_word_break_2;

import java.util.*;

public class Solution2 {

    public static void main(String[] args){
        String[] sArr = {"catsanddog","pineapplepenapple","catsandog"};
        String[][] wordsArr = {
                {"cat", "cats", "and", "sand", "dog"},
                {"apple", "pen", "applepen", "pine", "pineapple"},
                {"cats", "dog", "sand", "and", "cat"}
        };
        int len = sArr.length;
        for (int i = 0;i<len;i++){
            List<String> wordDict = new LinkedList<>(Arrays.asList(wordsArr[i]));
            System.out.println(wordBreak(sArr[i],wordDict));
        }
    }

    private static List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, List<String>>());
    }

    private static List<String> DFS(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)){
            return map.get(s);
        }
        List<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                // 以word.length()位置为起始的字符串的wordBreak结果
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
