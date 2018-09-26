package session3.q044_wildcard_matching;

public class Solution1 {

    public static void main(String[] args){
        String[] strs = {"aabaccbcd","aa"};
        String[] regs = {"aa**bcda","*"};
        for (int i = 0; i < strs.length; i++) {
            System.out.println(isMatch(strs[i], regs[i]));
        }
    }

    private static boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int startIdx = -1;
        int lastMatch = -1;
        int sLen = s.length();
        int pLen = p.length();
        while (sp < sLen){
            // s和p中的字符相等，或者p中字符为？
            if (pp < pLen && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                pp++;
                sp++;
            }
            // p中字符为*，记录最后一个*号出现位置及*号对应的字符串的最后一个匹配位置
            else if (pp < pLen && p.charAt(pp) == '*'){
                startIdx = pp;
                pp++;
                lastMatch = sp;
            }
            // s和p中字符不等，且也不是*或者？，但是*号曾经出现过
            else if (startIdx != -1){
                sp = lastMatch++;
                pp = startIdx + 1;
            }
            // 否则直接返false
            else {
                return false;
            }
        }
        // s已经到达最后
        while (pp < pLen && p.charAt(pp) == '*'){
            pp++;
        }
        return pp == pLen;
    }
}
