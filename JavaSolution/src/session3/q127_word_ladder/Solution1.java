package session3.q127_word_ladder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
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
        int len = wordList.size();
        boolean[] used = new boolean[len];
        List<String> tempList = new LinkedList<>();
        List<List<String>> possiblePath = new LinkedList<>();
        backTracking(wordList,tempList,used,beginWord,endWord,possiblePath);
        if (possiblePath.size() == 0){
            return 0;
        }
        else {
            return shortestLen(possiblePath) + 1;
        }
    }

    private static int wordDiff(String str1,String str2){
        int len = str1.length();
        int count = 0;
        for(int i = 0;i<len;i++){
            if (str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        return count;
    }

    private static void backTracking(List<String> wordList,List<String> tempList,boolean[] used, String begin,String end,List<List<String>> possiblePath){
        int len = wordList.size();
        if (begin.equals(end)){
            List<String> addList = new LinkedList<>(tempList);
            if (!possiblePath.contains(addList)){
                possiblePath.add(addList);
            }
        }
        else {
            for (int i=0;i<len;i++){
                if (!used[i] && wordDiff(begin,wordList.get(i)) == 1){
                    tempList.add(wordList.get(i));
                    used[i] = true;
                    backTracking(wordList,tempList,used,wordList.get(i),end,possiblePath);
                    used[i] = false;
                    if (tempList.size() > 0){
                        tempList.remove(tempList.size() - 1);
                    }
                }
            }
        }
    }

    private static int shortestLen(List<List<String>> possiblePath){
        int min = possiblePath.get(0).size();
        for (int i = 1;i<possiblePath.size();i++){
            min = Math.min(min,possiblePath.get(i).size());
        }
        return min;
    }
}
