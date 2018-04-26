package session3.q029_divide_two_integers;

public class Solution1 {
    public static void main(String[] args){
        int[] allDividend = {10,10,7,0,7,-2147483648};
        int[] allDivisor = {5,3,-3,-2,1,1};
        for(int i = 0;i<allDividend.length;i++){
            System.out.println(divide(allDividend[i],allDivisor[i]));
        }
    }

    private static int divide(int dividend, int divisor) {
        long dividendLong = (long) dividend;
        long divisorLong = (long) divisor;
        if(dividendLong >= 0 && divisorLong >0){
            return positiveDivide(dividendLong,divisorLong,true);
        }
        else if(dividend < 0 && divisor > 0){
            return positiveDivide(0-dividendLong,divisorLong,false);
        }
        else if(dividend < 0 && divisor < 0){
            return positiveDivide(0-dividendLong,0-divisorLong,true);
        }
        else {
            return positiveDivide(dividendLong,0-divisorLong,false);
        }
    }

    private static int positiveDivide(long dividend,long divisor,boolean resultSign){
        long result = 0;
        long remain = dividend;
        while (remain >= divisor){
            int i = 1;
            long temp = divisor;
            while ((temp << 1) < remain ){
                temp = temp << 1;
                i = i << 1;
            }
            result += i;
            remain -= temp;
        }
        if(resultSign && result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if (!resultSign && result + Integer.MIN_VALUE > 0){
            return Integer.MAX_VALUE;
        }
        else if(resultSign) {
            return (int) result;
        }
        else{
            return (int) (0-result);
        }
    }
}
