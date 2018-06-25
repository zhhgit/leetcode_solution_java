package session3.q097_interleaving_string;

public class Solution2 {

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
        // matrix[i][j] 代表了使用s1前i位，和s2前j位，能否组成s3的前i + j位置
        boolean[][] matrix = new boolean[len1 + 1][len2 + 1];
        matrix[0][0] = true;
        // s1使用0位
        for (int i = 1;i<= len2;i++){
            matrix[0][i] = matrix[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        // s2使用0位
        for (int i = 1;i<=len1;i++){
            matrix[i][0] = matrix[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        // 填充matrix其他位置
        for (int i = 1;i<=len1;i++) {
            for (int j = 1; j <= len2; j++) {
                matrix[i][j] = (matrix[i - 1][j] && s1.charAt(i-1) == s3.charAt(i + j - 1)) || (matrix[i][j - 1] && s2.charAt(j-1) == s3.charAt(i + j - 1));
            }
        }
        return matrix[len1][len2];
    }
}
