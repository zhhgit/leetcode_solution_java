package q028_implement_strStr;

/**
 * Created by zhanghao1 on 2017/10/25.
 */
public class Solution1 {
    public static void main(String[] args){
        String haystack = "abcde";
        String needle = "bc";
        System.out.println(strStr(haystack,needle));
    }

    private static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        //考虑特殊情况
        if(len1 < len2){
            return -1;
        }
        for(int i = 0; i <= len1-len2 ;i++){
            if(checkAllNeedle(haystack,needle,i)){
                return i;
            }
        }
        return -1;
    }

    //从特定位置开始检查全部needle
    private static boolean checkAllNeedle(String haystack,String needle,int pos){
        for(int i = 0; i<needle.length();i++){
            char curr = needle.charAt(i);
            if(curr != haystack.charAt(pos)){
                return false;
            }
            pos++;
        }
        return true;
    }
}
