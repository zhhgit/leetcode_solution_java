package session1.q029_divide_two_integers;

public class Solution1 {
    public static void main(String[] args){
        System.out.println(divide(18,2));
        System.out.println(divide(-18,2));
        System.out.println(divide(18,-2));
        System.out.println(divide(18,0));
        System.out.println(divide(Integer.MIN_VALUE,-1));
        System.out.println(divide(1,2));
        System.out.println(divide(2147483647,2));
        System.out.println(divide(-2147483648,2));
    }

    private static long ret;

    private static int divide(int dividend, int divisor) {
        ret = 0;
        long ldividend = (long) dividend;
        long ldivisor = (long) divisor;
        if((ldivisor==0) || ((ldividend==Integer.MIN_VALUE)&&(ldivisor==-1))){
            return Integer.MAX_VALUE;
        }
        else{
            if((ldividend<0)&&(ldivisor<0)){
                eachAdd(-ldividend,-ldivisor);
                return (int)ret;
            }
            else if((ldividend>=0)&&(ldivisor>0)){
                eachAdd(ldividend,ldivisor);
                return (int)ret;
            }
            else if((ldividend>=0)&&(ldivisor<0)){
                eachAdd(ldividend,-ldivisor);
                return (int)-ret;
            }
            else{
                eachAdd(-ldividend,ldivisor);
                return (int)-ret;
            }
        }
    }

    private static void eachAdd(long dividend,long divisor){
        while(dividend>=divisor){
            int i=0;
            while((divisor<<i)<=dividend){
                i++;
            }
            ret+=(1<<(i-1));
            long remain = dividend-(divisor<<(i-1));
            dividend = remain;
        }
    }
}
