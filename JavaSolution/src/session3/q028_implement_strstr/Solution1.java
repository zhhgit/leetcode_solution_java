package session3.q028_implement_strstr;

public class Solution1 {
    public static void main(String[] args){
        String[] haystackArr = {"hello","aaaaa","a"};
        String[] needleArr = {"ela","baa",""};
        for(int i = 0;i<haystackArr.length;i++){
            System.out.println(strStr(haystackArr[i],needleArr[i]));
        }
    }

    private static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        for(int i = 0;i<=len1 - len2;i++){
            for(int j = 0;j<len2;j++){
                if(needle.charAt(j) != haystack.charAt(i + j)){
                    break;
                }
                if(j == len2 - 1){
                    return i;
                }
            }
        }
        return -1;
    }
}
