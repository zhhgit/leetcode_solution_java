package session2.q010_regular_expression_matching;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr = {"aa","aa","aaa","aa","aa","ab","aab"};
        String[] pArr = {"a","aa","aa","a*",".*",".*","c*a*b"};
        for(int i = 0;i<sArr.length;i++){
            System.out.println(isMatch(sArr[i],pArr[i]));
        }
    }

    private static boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for(int i = 0;i< pLen;i++){
            if(p.charAt(i) == '*' && dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }
        for(int i = 0;i<sLen;i++){
            for(int j=0;j<pLen;j++){
                if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                else if (p.charAt(j) == '*'){
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                    else{
                        dp[i+1][j+1] = dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }
}
