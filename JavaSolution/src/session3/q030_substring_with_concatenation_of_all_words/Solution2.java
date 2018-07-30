package session3.q030_substring_with_concatenation_of_all_words;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args){
        String[] sArr = {"barfoothefoobarman","wordgoodstudentgoodword","","a"};
        String[][] wordsArr = {{"foo","bar"},{"word","student"},{},{}};
        int len = sArr.length;
        for (int i = 0;i<len;i++){
            System.out.println(findSubstring(sArr[i],wordsArr[i]));
        }
    }


    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new LinkedList<>();
        int len = s.length();
        if (words.length == 0 || len == 0){
            return ret;
        }
        int wordLen = words[0].length();
        int concatLen = wordLen * words.length;
        Map<String,Integer> should = new HashMap<>();
        // 拼接后的字符串应该具备的特征map
        for (int i = 0;i<words.length;i++){
            if (should.containsKey(words[i])){
                int oldVal = should.get(words[i]);
                should.put(words[i],oldVal + 1);
            }
            else {
                should.put(words[i],1);
            }
        }
        // 验证每一个可能的开始位置
        for (int i = 0;i<=len - concatLen;i++){
            Map<String,Integer> showMap = new HashMap<>();
            int j = 0;
            while (j < concatLen){
                String sub = s.substring(i + j,i + j +wordLen);
                // 出现了不该出现的字符串
                if (!should.containsKey(sub)){
                    break;
                }
                // 字符串可以出现
                else {
                    // 未曾出现过
                    if (!showMap.containsKey(sub)){
                        showMap.put(sub,1);
                    }
                    // 曾出现
                    else {
                        int count = showMap.get(sub);
                        // 出现次数已经达到或超过可出现次数
                        if (count >= should.get(sub)){
                            break;
                        }
                        else {
                            showMap.put(sub,count + 1);
                        }
                    }
                }
                j += wordLen;
            }
            if (j >= concatLen){
                ret.add(i);
            }
        }
        return ret;
    }

}
