package session3.q097_interleaving_string;

public class Solution1 {

    public static void main(String[] args){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String[] s3Arr = {"aadbbbaccc","aadbbcbcac"};
        for (String s3:s3Arr){
            System.out.println(isInterleave(s1,s2,s3));
        }
    }

    private static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3){
            return false;
        }
        if (len1 == 0 && len2 == 0) {
            return s3.length() == 0;
        }
        if (len1 == 0){
            return s2.equals(s3);
        }
        if (len2 == 0){
            return s1.equals(s3);
        }
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        char c3 = s3.charAt(0);
        if (c1 == c3 && c2 == c3){
            return isInterleave(s1.substring(1,len1),s2,s3.substring(1,len3)) || isInterleave(s1,s2.substring(1,len2),s3.substring(1,len3));
        }
        else if (c1 == c3){
            return isInterleave(s1.substring(1,len1),s2,s3.substring(1,len3));
        }
        else if (c2 == c3){
            return isInterleave(s1,s2.substring(1,len2),s3.substring(1,len3));
        }
        else {
            return false;
        }
    }
}
