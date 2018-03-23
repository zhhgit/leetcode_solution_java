package session1.q049_group_anagrams;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new LinkedList<>();
        HashMap<String,List<String>> hm = new HashMap<>();
        Arrays.sort(strs);
        if(strs.length == 0){
            return ret;
        }
        else{
            for(int i=0;i<strs.length;i++){
                char[] charArr = strs[i].toCharArray();
                Arrays.sort(charArr);
                String tempStr = String.valueOf(charArr);
                if(!hm.containsKey(tempStr)){
                    LinkedList<String> insert = new LinkedList<>();
                    insert.add(strs[i]);
                    hm.put(tempStr,insert);
                }
                else{
                    hm.get(tempStr).add(strs[i]);
                }
            }
            for(int i=0;i<hm.size();i++){
                hm.values();
            }
            ret.addAll(hm.values());
            return ret;
        }
    }
}
