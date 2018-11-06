package session3.q065_valid_number;

public class Solution1 {
    public static void main(String[] args){
        String[] arr = {"46.e3","-1","23."," 02 ","1","0.1","3e3",".2","e","."," ","a 0","0 0","0.0.1","ab1","ab","1e2a","53K"};
        for (String s:arr){
            System.out.println(s + ": "+ isNumber(s));
        }
    }

    private static boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) return false;
        boolean seenNum = false;
        boolean seenE = false;
        boolean seenD = false;
        s = s.trim();
        for (int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch(c) {
                // 出现'.'，如果曾出现过点，或者曾出现e，就是非法的
                case '.':
                    if (seenD || seenE) return false;
                    seenD = true;
                    break;
                // 出现'e'，如果e曾经出现过，或者没有出现过数字，就是非法的
                case 'e':
                    if (seenE || !seenNum) return false;
                    seenE = true;
                    seenNum = false;
                    break;
                // 正负号，如果不在首位，也不在e后面，就是非法的
                case '+':
                case '-':
                    if (i != 0 && s.charAt(i-1) != 'e') return false;
                    seenNum = false;
                    break;
                // 其他特殊字符，就是非法的
                default:
                    if (c - '0' < 0 || c - '0' > 9) return false;
                    seenNum = true;
            }
        }
        return seenNum;
    }
}
