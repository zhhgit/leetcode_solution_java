package q118_pascal_triangle;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhanghao1 on 2017/11/6.
 */
public class Solution1 {

    public static void main(String[] args){
        int num = 5;
        System.out.println(generate(num));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new LinkedList<>();
        if(numRows <= 0){
            return lists;
        }
        if(numRows == 1){
            LinkedList<Integer> list = new LinkedList<>();
            list.add(1);
            lists.add(list);
        }
        else{
            LinkedList<Integer> list = new LinkedList<>();
            list.add(1);
            lists.add(list);
            for(int i=1;i<numRows;i++){
                list = new LinkedList<>();
                list.add(1);
                for(int j = 1;j<i;j++){
                    list.add(lists.get(i-1).get(j-1) + lists.get(i-1).get(j));
                }
                list.add(1);
                lists.add(list);
            }
        }
        return lists;
    }
}
