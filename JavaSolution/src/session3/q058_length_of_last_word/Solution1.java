package session3.q058_length_of_last_word;

public class Solution1 {
    public static void main(String[] args){
        String[] strArr = {"Hello,world","Hello world","Hello world     ","","   "};
        for(String s:strArr){
            System.out.println(lengthOfLastWord(s));
        }
    }

    private static int lengthOfLastWord(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int i = 0;
        int index = len - 1;
        while (index >=0 && s.charAt(index) == ' '){
            index--;
        }
        while (index >= 0 && s.charAt(index) != ' '){
            i++;
            index--;
        }
        return i;
    }
}
