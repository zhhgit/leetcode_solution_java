package session3.q140_word_break_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
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
        List<List<String>> result = new LinkedList<>();
        List<String> tempList = new LinkedList<>();
        backTracking(s,0,wordDict,result,tempList);
        return convert(result);
    }

    private static void backTracking(String s, int pos, List<String> wordDict, List<List<String>> result,List<String> tempList){
        int len = s.length();
        if (pos == len){
            List<String> addList = new LinkedList<>(tempList);
            if (!result.contains(addList)){
                result.add(addList);
            }
        }
        else {
            for (int i = pos + 1;i <= len;i++){
                String tempStr = s.substring(pos,i);
                if (wordDict.contains(tempStr)){
                    tempList.add(tempStr);
                    backTracking(s,i,wordDict,result,tempList);
                    if (tempList.size() > 0){
                        tempList.remove(tempList.size() - 1);
                    }
                }
            }
        }
    }

    private static List<String> convert(List<List<String>> result){
        List<String> ret = new LinkedList<>();
        for (List<String> item:result){
            ret.add(listToStr(item));
        }
        return ret;
    }

    private static String listToStr(List<String> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<list.size();i++){
            stringBuilder.append(list.get(i));
            if (i != list.size() - 1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
