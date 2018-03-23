package session2.q166_fraction_to_recurring_decimal;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int[] left = {4,7,12,15,3,1,20,-20,0,-1};
        int[] right = {2,1,7,9,2,6,-7,-7,-1,-2147483648};
        for(int i = 0;i<left.length;i++){
            System.out.println(fractionToDecimal(left[i],right[i]));
        }
    }

    private static String fractionToDecimal(int numerator, int denominator) {
        long longNumerator = (long) numerator;
        long longDenominator = (long) denominator;
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)){
            return "-" + doCal(0 - longNumerator,longDenominator);
        }
        else{
            return doCal(longNumerator,longDenominator);
        }
    }

    private static String doCal(long numerator, long denominator){
        if(numerator % denominator == 0){
            return (numerator / denominator) + "";
        }
        else{
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(numerator / denominator);
            stringBuilder.append(".");
            stringBuilder.append(getFloat(numerator % denominator,denominator));
            return stringBuilder.toString();
        }
    }

    private static String getFloat(long left,long right){
        List<Long> leftList = new LinkedList<>();
        List<Long> resultList = new LinkedList<>();
        while (left != 0){
            long remain = (left * 10) % right;
            long temp = (left * 10) / right;
            leftList.add(left);
            resultList.add(temp);
            if(leftList.contains(remain)){
                int i = leftList.indexOf(remain);
                return getResultString(resultList,0,i) + "(" + getResultString(resultList,i,resultList.size() - i) + ")";
            }
            else{
                left = remain;
            }
        }
        return getResultString(resultList,0,resultList.size());
    }

    private static String getResultString(List<Long> list,int start,int len){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<len;i++){
            stringBuilder.append(list.get(i + start));
        }
        return stringBuilder.toString();
    }
}
