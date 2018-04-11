package session3.q014_longest_common_prefix;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"abcc","abd","abb","abcde","aa","a"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int pos = 0;
        int minLen = getMinLen(strs);
        while (pos < minLen){
            if(!allTheSameAtPos(strs,pos)){
                return strs[0].substring(0,pos);
            }
            pos++;
        }
        return strs[0].substring(0,minLen);
    }

    private static int getMinLen(String[] strs){
        int maxLen = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            maxLen = Math.min(maxLen,strs[i].length());
        }
        return maxLen;
    }

    private static boolean allTheSameAtPos(String[] strs,int pos){
        char c = strs[0].charAt(pos);
        for(int i=1;i<strs.length;i++){
            if(strs[i].charAt(pos) != c){
                return false;
            }
        }
        return true;
    }
}
