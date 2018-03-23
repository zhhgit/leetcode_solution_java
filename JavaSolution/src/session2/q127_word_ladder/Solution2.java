package session2.q127_word_ladder;

import java.util.*;

public class Solution2 {
    public static void main(String[] args){
        String beginWord = "sand";
        String endWord = "acne";
        List<String> wordList = new LinkedList<>(Arrays.asList("slit","sand","wars","ping","viva","wynn","wows","irks","gang","acne","mock","fort","heel","send","ship","cols"));
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)){
            return 1;
        }
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
                        //如果words中包含新产生的字符串，才处理
                        if (words.contains(newWord)) {
                            //正好结尾
                            if (newWord.equals(endWord)){
                                return level + 1;
                            }
                            //reached中不包含就添加进reached
                            else if (reached.add(newWord)){
                                //添加进队列
                                queue.add(newWord);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}