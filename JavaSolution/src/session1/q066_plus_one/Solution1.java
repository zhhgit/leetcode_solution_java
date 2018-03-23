package session1.q066_plus_one;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {9,9};
        int[] ret = plusOne(arr);
        int len = ret.length;
        for(int i=0; i<len; i++){
            System.out.println(ret[i]);
        }

    }

    private static int[] plusOne(int[] digits){
        int len = digits.length;
        int temp;
        int index = 0;
        int[] ret;
        boolean extraFlag = false;
        Stack<Integer> s = new Stack<Integer>();
        int increase = 1;
        for(int i = len-1; i>=0; i--){
            if((digits[i] == 9) && (increase == 1)){
                s.push(0);
                if(i==0){
                    s.push(1);
                    extraFlag = true;
                }
            }
            else{
                s.push(digits[i]+increase);
                increase = 0;
            }
        }
        if(extraFlag){
            ret = new int[len+1];
        }
        else {
            ret = new int[len];
        }
        while(!s.isEmpty()){
            temp = s.peek();
            s.pop();
            ret[index++] = temp;
        }
        return ret;
    }
}
