package session1.q028_implement_strstr;

public class Solution1 {
    public static  void main(String[] args){
        String haystack = "I live in Shanghai.";
        String needle = "Shanghai";
        System.out.println(strStr(haystack,needle));
    }

    private static int strStr(String haystack, String needle){
        int index;
        index = haystack.indexOf(needle);
        return index;
    }
}