package q089_gray_code;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 4;
        System.out.println(grayCode(n));
    }

    private static List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        if(n==0){
            list.add(0);
            return list;
        }
        list.add(0);
        list.add(1);
        int[] arr = getArray(n);
        for(int i=1;i<n;i++){
            List<Integer> tempList = new LinkedList<>(list);
            for(int j=tempList.size()-1;j>=0;j--){
                list.add(arr[i] + tempList.get(j));
            }
        }
        return list;
    }

    private static int[] getArray(int n){
        int[] retArray = new int[n];
        int i = 0;
        int num = 1;
        while(i < n){
            retArray[i] = num;
            num *= 2;
            i++;
        }
        return retArray;
    }
}
