package session3.q087_scramble_string;

public class Solution1 {
    public static void main(String[] args){
        String[] s1Arr = {"great","abcde","abab"};
        String[] s2Arr = {"rgeat","caebd","aabb"};
        for(int i = 0;i<s1Arr.length;i++){
            System.out.println(isScramble(s1Arr[i],s2Arr[i]));
        }
    }

    private static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2){
            return false;
        }
        int[] charArray = new int[26];
        for (int i = 0;i<len1;i++){
            charArray[s1.charAt(i) - 'a']++;
            charArray[s2.charAt(i) - 'a']--;
        }
        for (int i = 0;i<26;i++){
            if (charArray[i] != 0){
                return false;
            }
        }
        for (int i = 1;i<len1;i++){
            // 相同长度的在同一侧
            if (isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))){
                return true;
            }
            // 相同长度的在不同侧
            if (isScramble(s1.substring(0,i),s2.substring(len1 - i)) && isScramble(s1.substring(i),s2.substring(0,len1 - i))){
                return true;
            }
        }
        return false;
    }
}
