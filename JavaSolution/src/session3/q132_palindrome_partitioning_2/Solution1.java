package session3.q132_palindrome_partitioning_2;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String s = "aab";
        System.out.println(minCut(s));
    }

    private static int minCutNum = Integer.MAX_VALUE;

    private static int minCut(String s) {
        List<String> tempList = new LinkedList<>();
        backTracking(s,tempList,0);
        return minCutNum;
    }

    private static void backTracking(String s,List<String> tempList,int startPos){
        int len = s.length();
        if (startPos == len){
            int currCut = tempList.size() - 1;
            minCutNum = Math.min(minCutNum,currCut);
        }
        else {
            for (int i = startPos + 1;i <= len;i++){
                if (isPalindrome(s.substring(startPos,i))){
                    tempList.add(s.substring(startPos,i));
                    backTracking(s,tempList,i);
                    if (tempList.size() > 0){
                        tempList.remove(tempList.size() - 1);
                    }
                }
            }
        }
    }

    private static boolean isPalindrome(String s){
        int len = s.length();
        int left = 0;
        int right = len - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}