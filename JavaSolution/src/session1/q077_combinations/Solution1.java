package session1.q077_combinations;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int n = 5;
        int k = 3;
        System.out.println(combine(n,k));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        backTracking(list,tempList,k,1,n);
        return list;
    }

    private static void backTracking(List<List<Integer>> list,LinkedList<Integer> tempList,int remainK,int startPos,int n){
        if(remainK>(n-startPos+1)){
            tempList.remove(tempList.size()-1);
            return;
        }
        if(remainK==0){
            LinkedList<Integer> insert = new LinkedList(tempList);
            list.add(insert);
            tempList.remove(tempList.size()-1);
            return;
        }
        else{
            for(int i=startPos;i<=n;i++){
                tempList.add(i);
                backTracking(list,tempList,remainK-1,i+1,n);
            }
            if(tempList.size()>0){
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
