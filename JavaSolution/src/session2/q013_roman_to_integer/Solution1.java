package session2.q013_roman_to_integer;

import java.util.HashMap;

/**
 * Created by zhanghao1 on 2017/10/24.
 */
public class Solution1 {
    public static void main(String[] args){
        String[] strArr = {"III","IV","VI","XIX","XX","XLV","MCMLXXX"};
        for(String str: strArr){
            System.out.println(romanToInt(str));
        }
    }

    private static int romanToInt(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('X',10);
        hm.put('C',100);
        hm.put('M',1000);
        hm.put('V',5);
        hm.put('L',50);
        hm.put('D',500);
        int all = 0;
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(i<s.length()-1 && hm.get(currChar) < hm.get(s.charAt(i+1))){
                all -= hm.get(currChar);
            }
            else{
                all += hm.get(currChar);
            }
        }
        return all;
    }
}
