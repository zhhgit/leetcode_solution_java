package session1.q118_pascal_s_triangle;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            ret.add(new ArrayList<Integer>());
        }
        if(numRows < 1){
            return ret;
        }
        else if(numRows == 1){
            ret.get(0).add(1);
            return ret;
        }
        else{
            ret.get(0).add(1);
            for(int i = 1; i < numRows; i++){
                for(int j = 0; j<i+1; j++){
                    if((j==0) || (j==i)){
                        ret.get(i).add(1);
                    }
                    else{
                        ret.get(i).add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                    }
                }
            }
            return ret;
        }
    }
}
