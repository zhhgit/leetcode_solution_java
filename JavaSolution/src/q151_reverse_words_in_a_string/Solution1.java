package q151_reverse_words_in_a_string;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String s = " s";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        if(s.length() == 0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new LinkedList<>();
        int len = s.length();
        int start = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i) == ' '){
                if((i-1)>=0 && s.charAt(i-1) != ' '){
                    list.add(s.substring(start,i));
                    start = i;
                }
            }
            else{
                if((i-1)>=0 && s.charAt(i-1) == ' '){
                    start = i;
                }
            }
        }
        if(s.charAt(start) != ' '){
            list.add(s.substring(start,len));
        }
        for(int i = list.size()-1;i>=0;i--){
            stringBuilder.append(list.get(i));
            if(i!=0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
