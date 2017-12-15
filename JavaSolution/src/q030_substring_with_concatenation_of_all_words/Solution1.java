package q030_substring_with_concatenation_of_all_words;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s,words));
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<>();
        if(s.length() == 0 || words.length == 0){
            return list;
        }
        int wordLen = words[0].length();
        if(wordLen == 0 || wordLen * words.length > s.length()){
            return list;
        }
        int lastIndex = s.length() - wordLen * words.length;
        for(int i=0;i<=lastIndex;i++){
            boolean[] used = new boolean[words.length];
            List<String> tempList = new LinkedList<>();
            backTracking(list,s.substring(i),words,used,tempList,i);
        }
        return list;
    }

    //从每个字符串开始
    private static void backTracking(List<Integer> list,String s,String[] words,boolean[] used,List<String> tempList,int startPos){
        if(tempList.size() == words.length){
            if(!list.contains(startPos)){
                list.add(startPos);
            }
        }
        else{
            int wordLen = words[0].length();
            for(int i=0;i<words.length;i++){
                if(!used[i]){
                    if(s.indexOf(words[i]) == 0){
                        used[i] = true;
                        tempList.add(words[i]);
                        backTracking(list,s.substring(wordLen),words,used,tempList,startPos);
                        used[i] = false;
                        if(tempList.size() >0){
                            tempList.remove(tempList.size() - 1);
                        }
                    }
                }
            }
        }
    }
}
