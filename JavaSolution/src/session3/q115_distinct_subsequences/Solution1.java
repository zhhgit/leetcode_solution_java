package session3.q115_distinct_subsequences;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String s = "babgbag";
        String t = "bag";
        System.out.println(numDistinct(s,t));
    }

    private static int numDistinct(String s, String t) {
        if (s.length() < t.length()){
            return 0;
        }
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        backTracking(s,t,lists,tempList,0,0);
        return lists.size();
    }

    private static void backTracking(String s,String t,List<List<Integer>> lists,List<Integer> tempList,int sPos,int tPos){
        int sLen = s.length();
        int tLen = t.length();
        if (tPos >= tLen){
            List<Integer> addList = new LinkedList<>(tempList);
            if (!lists.contains(addList)){
                lists.add(addList);
            }
        }
        else {
            char target = t.charAt(tPos);
            for (int i = sPos;i<sLen;i++){
                if (s.charAt(i) == target){
                    tempList.add(i);
                    backTracking(s,t,lists,tempList,i + 1,tPos + 1);
                    if (tempList.size() > 0){
                        tempList.remove(tempList.size() - 1);
                    }
                }
            }
        }
    }
}