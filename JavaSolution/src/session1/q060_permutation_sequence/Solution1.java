package session1.q060_permutation_sequence;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int n = 9;
        int k = 24;
        System.out.println(getPermutation(n,k));
    }

    private static String getPermutation(int n, int k) {
        List<String> list = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        boolean[] used = new boolean[n];
        backTracking(list,sb,n,used);
        return list.get(k-1);
    }

    private static void backTracking(List<String> list,StringBuffer sb,int n,boolean[] used){
        if(sb.length()==n){
            list.add(sb.toString());
        }
        else{
            for(int i=1;i<=n;i++){
                if(!used[i-1]){
                    sb.append(i);
                    used[i-1] = true;
                    backTracking(list,sb,n,used);
                    sb.deleteCharAt(sb.length()-1);
                    used[i-1] = false;
                }
            }
        }
    }
}
