package session3.q089_gray_code;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 3;
        System.out.println(grayCode(n));
    }

    private static List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        if(n == 0){
            list.add(0);
            return list;
        }
        if(n == 1){
            list.add(0);
            list.add(1);
            return list;
        }
        list.add(0);
        list.add(1);
        int increase = 2;
        for(int i = 0;i<n-1;i++){
            eachRound(list,increase);
            increase = increase << 1;
        }
        return list;
    }

    private static void eachRound(List<Integer> list,int increase){
        int size = list.size();
        for(int i = size - 1;i>=0;i--){
            list.add(increase + list.get(i));
        }
    }
}
