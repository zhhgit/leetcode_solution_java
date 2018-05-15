package session3.q077_combinations;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 4;
        int k = 2;
        System.out.println(combine(n,k));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new LinkedList<>();
        if(n == 0 || k > n){
            return lists;
        }
        if(k == 0){
            lists.add(new LinkedList<>());
            return lists;
        }
        List<Integer> tempList = new LinkedList<>();
        backTracking(lists,tempList,0,n,k);
        return lists;
    }

    private static void backTracking(List<List<Integer>> lists,List<Integer> tempList,int pos,int n, int k){
        if(tempList.size() == k){
            List<Integer> addList = new LinkedList<>(tempList);
            if(!lists.contains(addList)){
                lists.add(addList);
            }
        }
        else{
            for(int i = pos;i<n;i++){
                tempList.add(i + 1);
                backTracking(lists,tempList,i + 1,n,k);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
