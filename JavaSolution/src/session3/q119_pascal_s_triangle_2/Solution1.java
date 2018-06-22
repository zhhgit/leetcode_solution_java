package session3.q119_pascal_s_triangle_2;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] rowArr = {0,1,2,3,4,5};
        for (int row:rowArr){
            System.out.println(getRow(row));
        }
    }

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new LinkedList<>();
        if (rowIndex == 0) {
            prev.add(1);
            return prev;
        }
        else {
            List<Integer> next;
            for(int i = 1;i<=rowIndex;i++){
                next = new LinkedList<>();
                for (int j = 0;j<i+1;j++){
                    if (j == 0 || j == i){
                        next.add(1);
                    }
                    else {
                        next.add(prev.get(j) + prev.get(j - 1));
                    }
                }
                prev = next;
            }
            return prev;
        }
    }
}
