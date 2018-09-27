package session3.q010_regular_expression_matching;

public class Solution1 {

    public static void main(String[] args){
        String[] sArr = {"aa","aa","aaa","aa","aa","ab","aab","mississippi"};
        String[] pArr = {"a","aa","aa","a*",".*",".*","c*a*b","mis*is*p*."};
        for(int i = 0;i<sArr.length;i++){
            System.out.println(isMatch(sArr[i],pArr[i]));
        }
    }

    private static boolean isMatch(String s, String p) {
        if (s == null || p == null){
            return false;
        }
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] matrix = new boolean[sLen + 1][pLen + 1];
        // s和p的长度都为0时，为true
        matrix[0][0] = true;
        // 第一列因为初始为false已经满足实际情况：即s长度不为0，p长度为0应该为false，所以不需要特别处理
        // 第一行即s长度为0，p长度不为0，只有a*或者.*的情况下才能为true
        for (int i = 0;i<pLen;i++){
            if (p.charAt(i) == '*' && matrix[0][i-1]){
                matrix[0][i + 1] = true;
            }
        }
        // 填充除第一行、第一列之外的其他位置
        for (int i = 0;i < sLen;i++){
            for (int j = 0;j < pLen;j++){
                // 如果s，p新增的最后一位相等，或者p最后一位为.，则matrix[i + 1][j + 1]与左上角相等
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    matrix[i + 1][j + 1] = matrix[i][j];
                }
                //  如果p最后一位为*
                else if (p.charAt(j) == '*'){
                    // 如果p中*的前一位与s中当前位相等，或者p中*的前一位为.，则a*或者.*匹配情况有三种：
                    // matrix[i + 1][j + 1]为matrix[i + 1][j]（情况1：对应于一位），
                    // 或为matrix[i + 1][j - 1]（情况2：对应于0位）
                    // 或为matrix[i][j+1]（情况3：对应于多位）
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.'){
                        matrix[i + 1][j + 1] = matrix[i + 1][j] || matrix[i + 1][j - 1] || matrix[i][j + 1];
                    }
                    // 否则a*匹配0位
                    else {
                        matrix[i + 1][j + 1] = matrix[i + 1][j - 1];
                    }
                }
            }
        }
        return matrix[sLen][pLen];
    }
}
