package session3.q076_minimum_window_substring;

public class Solution1 {

    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }

    private static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        // 记录t字符串的特征map，ASCII
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int m = s.length();
        int n = t.length();
        // 初始最短字符串长度
        int minLen = m + 1;
        int left = 0;
        // lo是低位指针位置
        int lo = 0;
        // cnt为lo-hi指针范围内的字符串中，满足t字符串的字符出现的个数
        int cnt = 0;
        // hi为高位指针位置
        for (int hi = 0; hi < m; hi++) {
            char c = s.charAt(hi);
            map[c]--;
            // 还大于等于0，说明是t中字符，cnt加1
            if (map[c] >= 0) {
                cnt++;
            }
            // 当出现的t中的字符数，跟t中应该出现的字符数相等，说明现在lo-hi范围内的字符串，是符合的
            while (cnt == n) {
                // 更新最短长度，更新left，记录起始位置
                if (minLen > hi - lo + 1) {
                    minLen = hi - lo + 1;
                    left = lo;
                }
                char pre = s.charAt(lo);
                map[pre]++;
                // 如果不大于0，说明pre位置是不在t中的其他字符，如果大于0，说明pre位置是在t中的字符
                if (map[pre] > 0) {
                    cnt--;
                }
                // lo指针加1，字符串变短1位置。
                lo++;
            }
        }
        return minLen == m + 1 ? "" : s.substring(left, left + minLen);
    }
}
