package session3.q006_zigZag_conversion;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }

    private static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<List<Character>> lists = new LinkedList<>();
        for(int i = 0;i<numRows;i++){
            lists.add(new LinkedList<Character>());
        }
        int len = s.length();
        int groupSize = numRows * 2 - 2;
        for(int i = 0;i<len;i++){
            char c = s.charAt(i);
            int index = i % groupSize;
            int groupId;
            if(index <  numRows){
                groupId = index;
            }
            else{
                groupId = 2 * numRows - 2 - index;
            }
            lists.get(groupId).add(c);
        }
        return getStrByRow(lists);
    }

    private static String getStrByRow(List<List<Character>> lists){
        int size = lists.size();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<size;i++){
            sb.append(getStrEachRow(lists.get(i)));
        }
        return sb.toString();
    }

    private static String getStrEachRow(List<Character> list){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
