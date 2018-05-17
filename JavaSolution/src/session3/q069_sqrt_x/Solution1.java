package session3.q069_sqrt_x;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
        for(int x:arr){
            System.out.println(mySqrt(x));
        }
    }

    private static int mySqrt(int x) {
        long root = 0;
        while (root * root <= x){
            root++;
        }
        return (int) (root - 1);
    }
}
