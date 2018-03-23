package session1.q067_add_binary;

import java.lang.*;

public class Solution1 {
    public static  void main(String[] args){
        String a = "0";
        String b = "0";
        System.out.println(addBinary(a,b));
    }

    private static String addBinary(String a, String b){
        StringBuffer sbRet = new StringBuffer();
        StringBuffer sba = new StringBuffer(a).reverse();
        StringBuffer sbb = new StringBuffer(b).reverse();
        int increase = 0,aTemp,bTemp,sumTemp,i;
        int len1 = a.length();
        int len2 = b.length();
        int max = Math.max(len1,len2);
        int min = Math.min(len1,len2);
        for(i =0; i<min; i++){
            aTemp = sba.charAt(i) - '0';
            bTemp = sbb.charAt(i) - '0';
            sumTemp = aTemp + bTemp + increase;
            increase = sumTemp / 2;
            sbRet.append(sumTemp % 2);
            if((max == min) && (i == min - 1) && (increase == 1)){
                sbRet.append(increase);
            }
        }
        for(; i<max; i++){
            if(len1>=len2){
                aTemp = sba.charAt(i) - '0';
                sumTemp = aTemp + increase;
            }
            else {
                bTemp = sbb.charAt(i) - '0';
                sumTemp = bTemp + increase;
            }
            increase = sumTemp / 2;
            sbRet.append(sumTemp % 2);
            if((i == max-1) && (increase == 1)){
                sbRet.append(increase);
            }
        }
        return sbRet.reverse().toString();
    }
}