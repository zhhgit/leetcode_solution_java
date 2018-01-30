package q072_edit_distance;

public class Solution1 {
    public static void main(String[] args){
        String word1 = "";
        String word2 = "a";
        System.out.println(minDistance(word1,word2));
    }

    private static int minDistance(String word1, String word2) {
        int iLen = word1.length();
        int jLen = word2.length();
        int[][] dp = new int[iLen + 1][jLen + 1];
        dp[0][0] = 0;
        for(int i = 0;i<jLen;i++){
            dp[0][i+1] = dp[0][i] + 1;
        }
        for(int i = 0;i<iLen;i++){
            dp[i+1][0] = dp[i][0] + 1;
        }
        for(int i = 0;i<iLen;i++){
            for(int j = 0;j<jLen;j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                else{
                    dp[i+1][j+1] = Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1])) + 1;
                }
            }
        }
        return dp[iLen][jLen];
    }
}
