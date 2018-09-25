package session3.q132_palindrome_partitioning_2;

public class Solution2 {
    public static void main(String[] args){
        String s = "aabac";
        System.out.println(minCut(s));
    }

    private static int minCut(String s) {
        int len = s.length();
        // f用来存储需要的切割刀数
        int[] f = new int[len];
        // 最多的情况，每个字符之间都切割
        for (int i = 0; i < len; i++) {
            f[i] = i;
        }
        // 考虑奇数、偶数的情况，向两侧扩展
        for (int i = 0; i < len; i++) {
            search(s, f, i, i);
            search(s, f, i, i + 1);
        }
        return f[len - 1];
    }

    private static void search(String s, int[] f, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (left == 0) {
                // left == 0, substring(0, right+1)是palindrome，无需切割
                f[right] = 0;
            }
            else {
                // f[right]的最新值为目前值，与从此位置向两侧最大扩展后，作则保存的值f[left-1] + 1中较小值
                f[right] = Math.min(f[right], f[left - 1] + 1);
            }
            left--;
            right++;
        }
    }
}