package session2.q050_pow_x_n;

public class Solution2 {
    public static void main(String[] args){
        System.out.println(myPow(1.2,6));
    }

    private static double myPow(double x, int n) {
        if(n == 0){
            return (double) 1;
        }
        else if(n > 0){
            return myPowPositive(x,n);
        }
        else{
            return 1 / myPowPositive(x,-n);
        }
    }

    private static double myPowPositive(double x,int n){
        if(n == 0){
            return (double) 1;
        }
        if(n % 2 == 0){
            return myPowPositive(x*x,n/2);
        }
        else {
            return myPowPositive(x*x,n/2) * x;
        }
    }
}
