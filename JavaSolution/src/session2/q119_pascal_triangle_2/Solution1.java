package session2.q119_pascal_triangle_2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhanghao1 on 2017/11/6.
 */
public class Solution1 {

    public static void main(String[] args){
        int num = 5;
        System.out.println(getRow(num));
    }

    private static List<Integer> getRow(int rowIndex) {
        int rowNum = rowIndex + 1;
        List<Integer> list = new LinkedList<>();
        if(rowNum <= 0){
            return list;
        }
        if(rowNum == 1){
            list.add(1);

        }
        else{
            LinkedList<Integer> temp;
            list.add(1);
            for(int i=1;i<rowNum;i++){
                temp = new LinkedList<>(list);
                list = new LinkedList<>();
                list.add(1);
                for(int j = 1;j<i;j++){
                    list.add(temp.get(j-1) + temp.get(j));
                }
                list.add(1);
            }
        }
        return list;
    }
}