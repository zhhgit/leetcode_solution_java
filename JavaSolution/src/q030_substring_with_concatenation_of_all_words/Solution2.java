package q030_substring_with_concatenation_of_all_words;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args){
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s,words));
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<>();
        //排除一些特殊情况
        if(s.length() == 0 || words.length == 0){
            return list;
        }
        int wordLen = words[0].length();
        if(wordLen == 0 || wordLen * words.length > s.length()){
            return list;
        }
        //应该出现的hashmap
        HashMap<String,Integer> should = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!should.containsKey(words[i])){
                should.put(words[i],0);
            }
            else{
                should.put(words[i],should.get(words[i]) + 1);
            }
        }
        //从每个起始位置开始
        int lastIndex = s.length() - wordLen * words.length;
        for(int i=0;i<=lastIndex;i++){
            HashMap<String,Integer> seen = new HashMap<>();
            int j = 0;
            while(j < words.length){
                String sub = s.substring(i + wordLen * j,i + wordLen * j + wordLen);
                //该子串不应该出现
                if(!should.containsKey(sub)){
                    break;
                }
                else{
                    //子串第一次出现
                    if(!seen.containsKey(sub)){
                        seen.put(sub,0);
                    }
                    else{
                        seen.put(sub,seen.get(sub) + 1);
                        //实际出现的次数大于了应该出现的次数
                        if(seen.get(sub) > should.get(sub)){
                            break;
                        }
                    }
                    j++;
                }
                if(j == words.length){
                    list.add(i);
                }
            }
        }
        return list;
    }
}
