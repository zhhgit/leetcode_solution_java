package session1.q050_pow_x_n;

public class Solution1 {
    public static void main(String[] args){
        double x = 1.0000;
        int n = Integer.MIN_VALUE;
        System.out.println(myPow(x,n));
    }

    private static double myPow(double x, int n) {
        double ret;
        if(n==0){
            return 1;
        }
        else if(n<0){
            if(n==Integer.MIN_VALUE){
                return myPow(x*x,n/2);
            }
            else{
                return myPow(1/x,-n);
            }
        }
        else{
            if(n%2==0){
                ret = myPow(x*x,n/2);
            }
            else{
                ret = myPow(x*x,n/2)*x;
            }
            return ret;
        }
    }
}
