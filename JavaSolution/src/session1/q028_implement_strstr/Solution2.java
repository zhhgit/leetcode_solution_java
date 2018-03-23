package session1.q028_implement_strstr;

public class Solution2 {
    public static  void main(String[] args){
        String haystack = "aaa";
        String needle = "a";
        System.out.println(strStr(haystack,needle));
    }

    private static int strStr(String haystack, String needle){
        int ret = -1;
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 == 0){
            ret = 0;
        }
        for(int i=0;i<len1 - len2 + 1;i++){
            for(int j=0; j<len2;j++){
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    break;
                }
                else if(j == len2-1){
                    return i;
                }
            }
        }
        return ret;
    }
}
