package session3.q017_letter_combinations_of_a_phone_number;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String digits = "29";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if(digits.length() == 0){
            return list;
        }
        char[][] strArr = {"abc".toCharArray(),"def".toCharArray(),
                "ghi".toCharArray(),"jkl".toCharArray(),
                "mno".toCharArray(),"pqrs".toCharArray(),
                "tuv".toCharArray(),"wxyz".toCharArray()};
        StringBuilder sb = new StringBuilder();
        backTracking(strArr,digits,0,list,sb);
        return list;
    }

    private static void backTracking(char[][] strArr,String digits,int pos,List<String> list,StringBuilder sb){
        if(pos == digits.length()){
            list.add(sb.toString());
        }
        else{
            int num = digits.charAt(pos) - '0';
            char[] cArr = strArr[num-2];
            for(int i = 0;i<cArr.length;i++){
                char c = cArr[i];
                sb.append(c);
                backTracking(strArr,digits,pos+1,list,sb);
                if(sb.toString().length() > 0){
                    sb.deleteCharAt(sb.toString().length()-1);
                }
            }
        }
    }
}
