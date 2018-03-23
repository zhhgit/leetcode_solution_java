package session2.q006_zigZag_conversion;

import java.util.LinkedList;

/**
 * Created by zhanghao1 on 2017/11/8.
 */
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
        LinkedList<StringBuffer> list = new LinkedList<>();
        for(int i=0;i<numRows;i++){
            list.add(new StringBuffer());
        }
        for(int i=0;i<s.length();i++){
            list.get(getRowNum(numRows,i)).append(s.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<numRows;i++){
            sb.append(list.get(i).toString());
        }
        return sb.toString();
    }

    private static int getRowNum(int numRows,int index){
        int divide = numRows * 2 - 2;
        int leftIndex = index % divide;
        if(leftIndex <= numRows -1){
            return leftIndex;
        }
        else{
            return 2*numRows-leftIndex-2;
        }
    }
}
