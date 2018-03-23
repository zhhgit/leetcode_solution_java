package session1.q119_pascal_s_triangle_2;

import java.util.*;

public class Solution2 {
    public static void main(String[] args){
        int rowIndex = 1;
        System.out.println(getRow(rowIndex));
    }

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        if(rowIndex < 0){
            return curr;
        }
        else if(rowIndex == 0){
            curr.add(1);
            return curr;
        }
        else{
            prev.add(1);
            for(int i = 0; i < rowIndex+1; i++){
                curr.clear();
                for(int j = 0; j<i+1; j++){
                    if((j==0) || (j==i)){
                        curr.add(1);
                    }
                    else{
                        curr.add(prev.get(j-1) + prev.get(j));
                    }
                }
                prev.clear();;
                for(int j = 0; j < curr.size();j++ ){
                    prev.add(curr.get(j));
                }
            }
            return curr;
        }
    }
}
