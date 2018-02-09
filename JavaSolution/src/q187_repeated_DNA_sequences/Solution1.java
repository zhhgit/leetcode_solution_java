package q187_repeated_DNA_sequences;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String s = "AAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }

    private static List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        List<String> list = new LinkedList<>();
        HashSet<String> hashSet = new HashSet<>();
        if(len <= 10){
            return list;
        }
        for(int i = 0;i<=len-10;i++){
            String str = s.substring(i,i+10);
            if(!hashSet.contains(str)){
                hashSet.add(str);
            }
            else{
                if(!list.contains(str)){
                    list.add(str);
                }
            }
        }
        return list;
    }
}
