package session3.q127_word_ladder;

import java.util.*;

public class Solution2 {
    public static void main(String[] args){
        List<String> wordList = new LinkedList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> reached = new HashSet<>();
        queue.add(beginWord);
        reached.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                String str = queue.poll();
                for (int j = 0;j<str.length();j++){
                    char[] cArr = str.toCharArray();
                    for(char c = 'a';c <= 'z';c++){
                        cArr[j] = c;
                        String newStr = new String(cArr);
                        if (words.contains(newStr)){
                            if (newStr.equals(endWord)){
                                return level + 1;
                            }
                            // 如果add方法返回true，也就是添加成功，说明之前没有出现过，应该添加到队列中。
                            else if (reached.add(newStr)){
                                queue.add(newStr);
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
