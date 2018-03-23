package session1.q127_word_ladder;

import java.util.*;

public class Solution2 {

    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new LinkedList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //此处size应该在每次while循环中保持，不能因为queue的操作而发生变化
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (words.contains(newWord)) {
                            if (newWord.equals(endWord)) return level + 1;
                            else if (reached.add(newWord)) queue.add(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
