package q058_length_of_last_word;

/**
 * Created by zhanghao1 on 2017/10/30.
 */
public class Solution1 {
    public static void main(String[] args){
        String[] strArr = {"hello world","","a "," a","a"};
        for(String s:strArr){
            System.out.println(lengthOfLastWord(s));
        }
    }
    private static int lengthOfLastWord(String s) {
        int index = s.length() -1;
        int count = 0;
        //跳过末尾的空格
        while(index >=0 && s.charAt(index) == ' '){
            index--;
        }
        while(index >=0 && s.charAt(index) != ' '){
            index--;
            count++;
        }
        return count;
    }
}
