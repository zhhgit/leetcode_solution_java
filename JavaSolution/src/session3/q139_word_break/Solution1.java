package session3.q139_word_break;

import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr = {"applepenapple","catsandog"};
        String[][] wordDictArr = {{"apple","pen"},{"cats", "dog", "sand", "and", "cat"}};
        for (int i = 0;i<sArr.length;i++){
            String s = sArr[i];
            List<String> wordDict = Arrays.asList(wordDictArr[i]);
            System.out.println(wordBreak(s,wordDict));
        }
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // breakable[i]存储的是i长度的字符串是否是可以进行wordBreak的
        boolean[] breakable = new boolean[len + 1];
        breakable[0] = true;
        for (int i = 1;i<=len;i++){
            for (int j = 0;j<i;j++){
                if (breakable[j] && wordDict.contains(s.substring(j,i))){
                    breakable[i] = true;
                }
            }
        }
        return breakable[len];
    }
}
