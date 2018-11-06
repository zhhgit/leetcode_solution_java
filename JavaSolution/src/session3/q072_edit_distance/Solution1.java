package session3.q072_edit_distance;

public class Solution1 {

    public static void main(String[] args){
        String[] word1Arr = {"horse","intention"};
        String[] word2Arr = {"ros","execution"};
        for (int i = 0;i<word1Arr.length;i++){
            System.out.println(minDistance(word1Arr[i],word2Arr[i]));
        }
    }

    private static int minDistance(String word1, String word2) {
        int row = word1.length();
        int column = word2.length();
        // matrix[i][j]表示word1的前i位转换到word2的前j为的最小操作步数
        int[][] matrix = new int[row + 1][column + 1];
        matrix[0][0] = 0;
        // 首行
        for (int i = 1;i<=column;i++){
            matrix[0][i] = i;
        }
        // 首列
        for (int i = 1;i<=row;i++){
            matrix[i][0] = i;
        }
        for (int i = 1;i<=row;i++){
            for (int j=1;j<=column;j++){
                // 如果word1,word2末尾补充的一位恰好相等，操作步数与之前相同
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    matrix[i][j] = matrix[i-1][j-1];
                }
                // 否则为上（在末尾添加）、左(在末尾删除)、左上最小值（替换）+1
                else {
                    matrix[i][j] = Math.min(Math.min(matrix[i-1][j-1],matrix[i][j-1]),matrix[i-1][j]) + 1;
                }
            }
        }
        return matrix[row][column];
    }
}
