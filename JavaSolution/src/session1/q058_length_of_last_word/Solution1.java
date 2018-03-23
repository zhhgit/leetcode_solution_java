package session1.q058_length_of_last_word;

public class Solution1 {
    public static void main(String[] args){
        String[] s = {"I live in Shanghai","a "," ",""};
        for(int i=0;i<s.length;i++){
            System.out.println(lengthOfLastWord(s[i]));
        }
    }

    private static int lengthOfLastWord(String s){
        int ret = 0,len;
        char[] cArr = s.toCharArray();
        len = cArr.length;
        int i = len-1;
        while((i>=0) && (cArr[i] == ' ')){
            i--;
        }
        for(; i >= 0; i--){
            if(cArr[i] != ' '){
                ret++;
            }
            else {
                break;
            }
        }
        return ret;
    }
}
