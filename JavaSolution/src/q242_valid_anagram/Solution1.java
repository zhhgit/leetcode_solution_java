package q242_valid_anagram;

import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr = {"anagram","rat"};
        String[] tArr = {"nagaram","cat"};
        for(int i= 0;i<sArr.length;i++){
            System.out.println(isAnagram(sArr[i],tArr[i]));
        }
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(!hashMap.containsKey(c)){
                hashMap.put(c,1);
            }
            else{
                hashMap.put(c,hashMap.get(c) + 1);
            }
        }
        for(int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            if(!hashMap.containsKey(c)){
                return false;
            }
            else{
                int count = hashMap.get(c);
                if(count > 1){
                    hashMap.put(c,count-1);
                }
                else{
                    hashMap.remove(c);
                }
            }
        }
        return hashMap.isEmpty();
    }
}
