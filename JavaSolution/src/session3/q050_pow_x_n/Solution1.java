package session3.q050_pow_x_n;

public class Solution1 {
    public static void main(String[] args){
        double[] xArr = {2.1,2.0};
        int[] nArr = {3,10};
        for(int i = 0;i<xArr.length;i++){
            System.out.println(myPow(xArr[i],nArr[i]));
        }
    }

    private static double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(new Double(x).equals(0.0)){
            if(n < 0){
                return Double.POSITIVE_INFINITY;
            }
            else{
                return 0.0;
            }
        }
        else if(n < 0){
            return myPowPositive(1/x,0 - (long) n);
        }
        else{
            return myPowPositive(x,(long) n);
        }
    }

    private static double myPowPositive(double x,long n){
        if(n == 1){
            return x;
        }
        else{
            if(n % 2 == 1){
                return myPowPositive(x,n-1) * x;
            }
            else{
                return myPowPositive(x*x,n / 2);
            }
        }
    }
}
