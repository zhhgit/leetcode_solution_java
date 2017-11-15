package q017_letter_combinations_of_a_phone_number;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String digits = "123456";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        String[] dictionary = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new LinkedList<>();
        if(digits.length() == 0){
            return list;
        }
        for(int i=0;i<digits.length();i++){
            String each = dictionary[digits.charAt(i) - '0'];
            if(i==0){
                for(int j=0;j<each.length();j++){
                    list.add(Character.toString(each.charAt(j)));
                }
            }
            else{
                List<String> nextList = new LinkedList<>();
                for(int j=0;j<each.length();j++){
                    for(String item:list){
                        nextList.add(item + Character.toString(each.charAt(j)));
                    }
                }
                list = nextList;
            }
        }
        return list;
    }
}
