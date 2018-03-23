package session1.q017_letter_combinations_of_a_phone_number;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        String digits = "212";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        LinkedList<String> ret = new LinkedList<String>();
        if(digits.length()>0){
            String[] keyboard = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            ret.add("");
            for(int i=0;i<digits.length();i++){
                String currDic = keyboard[Character.digit(digits.charAt(i),10)];
                while(ret.peek().length() == i){
                    String temp = ret.remove();
                    for(int j=0;j<currDic.length();j++){
                        ret.add(temp+currDic.charAt(j));
                    }
                }
            }
        }
        return ret;
    }
}
