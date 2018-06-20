package session3.q118_pascal_s_triangle;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        for (int numRows:arr){
            System.out.println(generate(numRows));
        }
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new LinkedList<>();
        if (numRows == 0){
            return lists;
        }
        int row = 1;
        while (row <= numRows){
            List<Integer> addList = new LinkedList<>();
            if (row == 1){
                addList.add(1);
            }
            else {
                List<Integer> prev = lists.get(lists.size() - 1);
                for (int i = 0;i<row;i++){
                    if (i == 0 || i == row - 1){
                        addList.add(1);
                    }
                    else {
                        addList.add(prev.get(i) + prev.get(i-1));
                    }
                }
            }
            lists.add(addList);
            row++;
        }
        return lists;
    }
}
