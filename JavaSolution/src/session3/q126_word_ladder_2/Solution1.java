package session3.q126_word_ladder_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        String[] strArr = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new LinkedList<>(Arrays.asList(strArr));
        System.out.println(findLadders(beginWord,endWord,wordList));
    }

    private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lists = new LinkedList<>();
        List<String> tempList = new LinkedList<>();
        tempList.add(beginWord);
        boolean[] used = new boolean[wordList.size()];
        if (!wordList.contains(endWord)){
            return lists;
        }
        backTracking(lists,tempList,used,wordList,endWord);
        return lists;
    }

    private static void backTracking(List<List<String>> lists,List<String> tempList,boolean[] used,List<String> wordList,String endWord){
        String curr = tempList.get(tempList.size() - 1);
        if (curr.equals(endWord)){
            List<String> addList = new LinkedList<>(tempList);
            if (lists.size() == 0){
                lists.add(addList);
            }
            else {
                int oldLen = lists.get(0).size();
                int newLen = addList.size();
                // 要求最短转换序列，所以如果发现更短的clear List<String>
                if (newLen < oldLen){
                    lists.clear();
                    if (!lists.contains(addList)){
                        lists.add(addList);
                    }
                }
                else if (newLen == oldLen){
                    if (!lists.contains(addList)){
                        lists.add(addList);
                    }
                }
            }
        }
        else {
            int len = wordList.size();
            for (int i = 0;i<len;i++){
                if (!used[i] && isValidNext(curr,wordList.get(i))){
                    tempList.add(wordList.get(i));
                    used[i] = true;
                    backTracking(lists,tempList,used,wordList,endWord);
                    used[i] = false;
                    if (tempList.size() > 0){
                        tempList.remove(tempList.size() - 1);
                    }
                }
            }
        }
    }

    private static boolean isValidNext(String curr,String str){
        int len1 = curr.length();
        int len2 = str.length();
        if (len1 != len2){
            return false;
        }
        int count = 0;
        for (int i = 0;i<len1;i++){
            if (curr.charAt(i) != str.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}
