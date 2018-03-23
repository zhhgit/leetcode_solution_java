package session2.q050_pow_x_n;

public class Solution1 {
    public static void main(String[] args){
        System.out.println(myPow(1.2,6));
    }

    private static double[] tempArr = new double[32];

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
        double temp = x;
        int index = 1;
        int pos = 0;
        tempArr[pos] = temp;
        while ((index << 1) > 0 && (index << 1) < Integer.MAX_VALUE && n >= (index << 1)){
            index = index << 1;
            pos++;
            if(tempArr[pos] == 0){
                temp = temp * temp;
                tempArr[pos] = temp;
            }
        }
        return myPowPositive(x,n-index) * tempArr[pos];
    }
}
