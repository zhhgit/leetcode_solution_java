package q127_word_ladder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "lot";
        List<String> wordList = new LinkedList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    private static int minStep = Integer.MAX_VALUE;

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        int listLen = wordList.size();
        boolean[] used = new boolean[listLen];
        List<String> tempList = new LinkedList<>();
        backTracking(beginWord,endWord,wordList,used,tempList);
        if(minStep == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return minStep;
        }
    }

    private static void backTracking(String begin,String end,List<String> wordList,boolean[] used,List<String> tempList){
        if(begin.equals(end)){
            minStep = Math.min(tempList.size() + 1,minStep);
        }
        else{
            for(int i=0;i<wordList.size();i++){
                if(!used[i] && validNext(begin,wordList.get(i))){
                    used[i] = true;
                    tempList.add(wordList.get(i));
                    backTracking(wordList.get(i),end,wordList,used,tempList);
                    used[i] = false;
                    if(tempList.size() > 0){
                        tempList.remove(tempList.size() -1);
                    }
                }
            }
        }
    }

    private static boolean validNext(String begin,String end){
        int len = begin.length();
        int diff = 0;
        for(int i = 0;i<len;i++){
            if(begin.charAt(i) != end.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}
