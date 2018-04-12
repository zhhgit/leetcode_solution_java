package session3.q013_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"DCXXI","XI","IX","XIV"};
        for(String s:strs){
            System.out.println(romanToInt(s));
        }
    }

    private static int romanToInt(String s) {
        Map<Character,Integer> map = getMap();
        int sum = 0;
        int minus = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            sum += map.get(c);
        }
        for(int i=0;i<s.length()-1;i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                char c = s.charAt(i);
                minus += map.get(c);
            }
        }
        return sum - 2 * minus;
    }

    private static Map<Character,Integer> getMap(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }
}
