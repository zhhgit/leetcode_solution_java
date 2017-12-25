package q205_isomorphic_strings;

import java.util.HashMap;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr = {"paper","egg","foo"};
        String[] tArr = {"title","add","bar"};
        for(int i=0;i<sArr.length;i++){
            System.out.println(isIsomorphic(sArr[i],tArr[i]));
        }
    }

    private static boolean isIsomorphic(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen != tLen){
            return false;
        }
        HashMap<Character,Character> hashMap = new HashMap<>();
        for(int i=0;i<sLen;i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            //key没有出现过是新的
            if(!hashMap.containsKey(sChar)){
                //value出现过
                if(hashMap.containsValue(tChar)){
                    return false;
                }
                //value没出现过
                else{
                    hashMap.put(sChar,tChar);
                }
            }
            //key出现过
            else{
                if(hashMap.get(sChar) != tChar){
                    return false;
                }
            }
        }
        return true;
    }
}
