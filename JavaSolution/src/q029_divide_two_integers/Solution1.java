package q029_divide_two_integers;

public class Solution1 {
    public static void main(String[] args){
        System.out.println(divide(Integer.MIN_VALUE,-1));
        System.out.println(divide(56,-2));
        System.out.println(divide(-56,3));
        System.out.println(divide(56,0));
        System.out.println(divide(56,7));
        System.out.println(divide(56,9));
    }

    private static int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        long dividendLong = (long) dividend;
        long divisorLong = (long) divisor;
        long result = 0;
        if(dividendLong >=0 && divisorLong >0){
            result = addEach(dividendLong,divisorLong);
            return (int) result;
        }
        else if(dividendLong >=0 && divisorLong <0){
            result = addEach(dividendLong,-divisorLong);
            return (int) -result;
        }
        else if(dividendLong <0 && divisorLong >0){
            result = addEach(-dividendLong,divisorLong);
            return (int) -result;
        }
        else{
            result = addEach(-dividendLong,-divisorLong);
            return (int) result;
        }
    }

    private static long addEach(long dividend,long divisor){
        long result = 0;
        while(dividend >= divisor){
            int i=0;
            while((divisor << i) <= dividend){
                i++;
            }
            result += 1<<(i-1);
            dividend -= (divisor)<<(i-1);
        }
        return result;
    }
}
