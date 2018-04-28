package session3.q049_group_anagrams;

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
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            String sortedStr = getSortedStr(strs[i]);
            if(!map.containsKey(sortedStr)){
                List<String> addList = new LinkedList<>();
                addList.add(strs[i]);
                map.put(sortedStr,addList);
            }
            else{
                List<String> list = map.get(sortedStr);
                list.add(strs[i]);
            }
        }
        for(String s:map.keySet()){
            lists.add(map.get(s));
        }
        return lists;
    }

    private static String getSortedStr(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
