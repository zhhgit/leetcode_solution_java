package q131_palindrome_partitioning;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String s = "aab";
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> lists = new LinkedList<>();
        if(s.length() == 0){
            return lists;
        }
        List<String> tempList = new LinkedList<>();
        backTracking(s,lists,tempList,0);
        return lists;
    }

    private static void backTracking(String s,List<List<String>> lists, List<String> tempList,int startPos){
        int len = s.length();
        if(startPos >= len){
            if(!lists.contains(tempList)){
                List<String> addList = new LinkedList<>(tempList);
                lists.add(addList);
            }
        }
        else{
            for(int i = startPos + 1;i<=len;i++){
                if(isPalindrome(s.substring(startPos,i))){
                    tempList.add(s.substring(startPos,i));
                    backTracking(s,lists,tempList,i);
                    if(tempList.size() > 0){
                        tempList.remove(tempList.size()-1);
                    }
                }
            }
        }
    }

    private static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
