package session2.q202_happy_number;

import java.util.HashSet;

public class Solution1 {
    public static void main(String[] args){
        int[] nums = {34,45,56,67,19};
        for(int n:nums){
            System.out.println(isHappy(n));
        }
    }

    private static boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while(hashSet.isEmpty() || !hashSet.contains(n)){
            hashSet.add(n);
            n = getNext(n);
        }
        return hashSet.contains(1);
    }

    private static int getNext(int n){
        int ret = 0;
        while(n > 0){
            int lastNm = n % 10;
            ret += lastNm * lastNm;
            n = n / 10;
        }
        return ret;
    }
}
