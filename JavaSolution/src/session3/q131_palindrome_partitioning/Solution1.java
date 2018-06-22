package session3.q131_palindrome_partitioning;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args){
        String s = "aab";
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> lists = new LinkedList<>();
        if (len == 0){
            return lists;
        }
        if (len == 1){
            List<String> addList = new LinkedList<>();
            addList.add(s);
            lists.add(addList);
            return lists;
        }
        List<String> tempList = new LinkedList<>();
        backTracking(s,lists,tempList,0);
        return lists;
    }

    private static void backTracking(String s,List<List<String>> lists,List<String> tempList,int pos){
        int len = s.length();
        if (pos == len){
            List<String> addList = new LinkedList<>(tempList);
            if (!lists.contains(addList)){
                lists.add(addList);
            }
        }
        else if (pos < len) {
            for (int i = pos + 1;i <=len;i++){
                String str = s.substring(pos,i);
                if (isPalindrome(str)){
                    tempList.add(str);
                    backTracking(s,lists,tempList,i);
                    if (tempList.size() > 0){
                        tempList.remove(tempList.size() - 1);
                    }
                }
            }
        }
    }

    private static boolean isPalindrome (String s){
        int len = s.length();
        if (len == 0 || len == 1){
            return true;
        }
        int left = 0,right = len - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
