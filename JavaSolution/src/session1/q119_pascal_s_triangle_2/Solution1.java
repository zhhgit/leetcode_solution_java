package session1.q119_pascal_s_triangle_2;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int rowIndex = 27;
        System.out.println(getRow(rowIndex));
    }

    private static int getEach(int i, int j){
        if((j == 0) || (j == i)){
            return 1;
        }
        else{
            return getEach(i-1,j-1) + getEach(i-1,j);
        }
    }

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        if(rowIndex < 0){
            return ret;
        }
        else if(rowIndex == 0){
            ret.add(1);
            return ret;
        }
        else{
            for(int i = 0; i <= rowIndex; i++){
                ret.add(getEach(rowIndex,i));
            }
            return ret;
        }
    }
}
