package session3.q151_reverse_words_in_a_string;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String[] strArr = {"the sky is blue"," ","","aa  bb ","    ab a"};
        for (String s:strArr){
            System.out.println(reverseWords(s));
        }
    }

    private static String reverseWords(String s) {
        if (s == null){
            return "";
        }
        s = s.trim();
        int len = s.length();
        if (len == 0){
            return "";
        }
        List<String> list = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < len){
            char c = s.charAt(i);
            if (c == ' '){
                list.add(stringBuilder.toString());
                stringBuilder.delete(0,stringBuilder.length());
                while (i < len && s.charAt(i) == ' '){
                    i++;
                }
            }
            else {
                stringBuilder.append(c);
                i++;
            }
        }
        if (stringBuilder.toString().length() > 0){
            list.add(stringBuilder.toString());
        }
        return convert(list);
    }

    private static String convert(List<String> list){
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = size - 1;i >= 0;i--){
            stringBuilder.append(list.get(i));
            if (i != 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
