package q044_wildcard_matching;

public class Solution1 {
    public static void main(String[] args) {
        String[] strs = {"aabaccbcd"};
        String[] regs = {"aa**bcda"};
        for (int i = 0; i < strs.length; i++) {
            System.out.println(isMatch(strs[i], regs[i]));
        }
    }

    private static boolean isMatch(String s, String p) {
        int sp = 0, pp = 0, match = 0, starIdx = -1;
        //s长度之内
        while (sp < s.length()){
            //p为？或者p与s相同
            if (pp < p.length()  && (p.charAt(pp) == '?' || s.charAt(sp) == p.charAt(pp))){
                sp++;
                pp++;
            }
            //p为*，用startIdx记录最后一个*出现的位置，match记录对应于这个*的最后一个s中的字符的后一位
            else if (pp < p.length() && p.charAt(pp) == '*'){
                starIdx = pp;
                match = sp;
                pp++;
            }
            //*曾出现，当前p与s不匹配，改变match,*对应的字符加长，
            else if (starIdx != -1){
                pp = starIdx + 1;
                match++;
                sp = match;
            }
            //也没出现*，直接false
            else{
                return false;
            }
        }
        //s已经遍历完，如果p还没有，且为*，直接向后移动
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp == p.length();
    }
}