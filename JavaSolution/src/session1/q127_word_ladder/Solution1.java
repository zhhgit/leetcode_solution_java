package session1.q127_word_ladder;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new LinkedList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> reached = new LinkedList<>();
        reached.add(beginWord);
        int distance = 1;
        List<String> unreached = new LinkedList<>(wordList);
        while(!reached.contains(endWord)){
            List<String> toAdd = new LinkedList<>();
            for(String each:reached){
                for(int i=0;i<each.length();i++){
                    for(char c='a';c<='z';c++){
                        char[] charArr = each.toCharArray();
                        charArr[i] = c;
                        String target = new String(charArr);
                        if(unreached.contains(target)){
                            unreached.remove(target);
                            toAdd.add(target);
                        }
                    }
                }
            }
            if (toAdd.size() == 0){
                return 0;
            }
            reached = toAdd;
            distance++;
        }
        return distance;
    }
}
