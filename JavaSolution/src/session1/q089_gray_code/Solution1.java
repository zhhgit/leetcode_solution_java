package session1.q089_gray_code;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int n = 3;
        System.out.println(grayCode(n));
    }

    private static List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        list.add(0);
        backTracking(list,0,1,n);
        return list;
    }

    private static void backTracking(List<Integer> list,int currN,int currIncrease,int n){
        if(currN == n){
            return;
        }
        else{
            for(int i=currIncrease-1;i>=0;i--){
                list.add(currIncrease+list.get(i));
            }
            currIncrease *= 2;
            backTracking(list,currN+1,currIncrease,n);
        }
    }
}
