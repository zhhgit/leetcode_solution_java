package session2.q077_combinations;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 5;
        int k = 4;
        System.out.println(combine(n,k));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new LinkedList<>();
        if(n<=0 || k>n){
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        boolean[] used = new boolean[n];
        backTracking(lists,tempList,used,n,k);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists,List<Integer> tempList,boolean[] used,int n,int k){
        if(tempList.size() == k){
            List<Integer> addList = new LinkedList<>(tempList);
            lists.add(addList);
        }
        else{
            int prev;
            if(tempList.size() > 0){
                prev = tempList.get(tempList.size()-1);
            }
            else{
                prev = 1;
            }
            for(int i = prev-1;i<n;i++){
                if(!used[i]){
                    tempList.add(i+1);
                    used[i] = true;
                    backTracking(lists,tempList,used,n,k);
                    tempList.remove(tempList.size()-1);
                    used[i] = false;
                }
            }
        }
    }
}
