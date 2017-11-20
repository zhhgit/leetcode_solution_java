package q049_group_anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new LinkedList<>();
        if(strs.length == 0){
            return lists;
        }
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for(String str:strs){
            String strKey = formatStr(str);
            if(!hashMap.containsKey(strKey)){
                List<String> addList = new LinkedList<>();
                addList.add(str);
                hashMap.put(strKey,addList);
            }
            else{
                hashMap.get(strKey).add(str);
            }
        }
        for(String str:hashMap.keySet()){
            lists.add(hashMap.get(str));
        }
        return lists;
    }

    private static String formatStr(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
