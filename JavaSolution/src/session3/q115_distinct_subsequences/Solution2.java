package session3.q115_distinct_subsequences;

public class Solution2 {

    public static void main(String[] args){
        String s = "babgbag";
        String t = "bag";
        System.out.println(numDistinct(s,t));
    }

    private static int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] matrix = new int[sLen + 1][tLen + 1];
        matrix[0][0] = 1;
        for (int i = 1;i <= sLen;i++){
            matrix[i][0] = 1;
        }
        for (int i = 1;i<=tLen;i++){
            matrix[0][i] = 0;
        }
        // matrix[i][j]表示s的前i位，t的前j位，满足条件的种数
        for (int j = 1;j<=tLen;j++){
            for (int i = 1;i<=sLen;i++){
                if (i < j){
                    matrix[i][j] = 0;
                }
                // 当s增加了一位，增加的一位可以参与匹配，也可以不参与匹配
                else {
                    int num = 0;
                    if (s.charAt(i-1) == t.charAt(j-1)){
                        num += matrix[i-1][j-1];
                    }
                    num += matrix[i-1][j];
                    matrix[i][j] = num;
                }
            }
        }
        return matrix[sLen][tLen];
    }
}
