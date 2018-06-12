package session3.q120_triangle;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args){
        int[][] numArr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0;i<numArr.length;i++){
            List<Integer> addList = new LinkedList<>();
            for(int j = 0;j<numArr[i].length;j++){
                addList.add(numArr[i][j]);
            }
            lists.add(addList);
        }
        System.out.println(minimumTotal(lists));
    }

    private static int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        if (level == 0){
            return 0;
        }
        if (level == 1){
            return triangle.get(0).get(0);
        }
        for (int i = level - 2;i>=0;i--){
            for(int j = 0;j<triangle.get(i).size();j++){
                int oldVal = triangle.get(i).get(j);
                int newVal = oldVal + Math.min(triangle.get(i + 1).get(j),triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j,newVal);
            }
        }
        return triangle.get(0).get(0);
    }
}
